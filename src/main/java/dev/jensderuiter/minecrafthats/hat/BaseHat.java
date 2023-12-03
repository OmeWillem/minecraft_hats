package dev.jensderuiter.minecrafthats.hat;

import dev.jensderuiter.minecrafthats.HatsPlugin;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4d;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHat implements Hat {

    protected List<HatComponent> components;
    protected HatRunnable runnable;

    @Getter
    protected final Player player;

    public BaseHat(Player player) {
        this.player = player;
        this.components = new ArrayList<>();
        this.runnable = new HatRunnable(this);
    }

    @Override
    public void spawn() {
        // everything happens in the same tick,
        // so it's not a problem if this is executed in an overwritten method
        this.runnable.runTaskTimer(HatsPlugin.getInstance(), 0, 1);
    }

    @Override
    public void destroy() {
        this.components.forEach(HatComponent::destroy);
        this.runnable.cancel();
    }

    @Override
    public void tick(Location location) {
        this.components.forEach(component -> component.tick(location.getYaw(), location.getPitch()));
    }

    protected ItemDisplay initDisplay(Material item, Vector3f scale, AxisAngle4d rotation) {
        ItemDisplay display = (ItemDisplay) player.getWorld().spawnEntity(
                player.getLocation(), EntityType.ITEM_DISPLAY);
        display.setItemStack(new ItemStack(item));

        Transformation displayTransformation = display.getTransformation();
        displayTransformation.getScale().set(scale);
        displayTransformation.getLeftRotation().set(rotation);
        display.setTransformation(displayTransformation);
        return display;
    }

    protected HatComponent addComponent(Material item, Vector offset, Vector3f scale, AxisAngle4d rotation) {
        ItemDisplay display = this.initDisplay(item, scale, rotation);
        HatComponent component = new HatComponent(display, this.getPlayer(), offset);

        this.components.add(component);
        return component;
    }

    protected HatComponent addComponent(Material item, Vector offset, float scale, AxisAngle4d rotation) {
        return this.addComponent(item, offset, new Vector3f(scale, scale, scale), rotation);
    }

    protected HatComponent addComponent(Material item, Vector offset, float scale) {
        return this.addComponent(item, offset, new Vector3f(scale, scale, scale), new AxisAngle4d(0, 1, 1, 1));
    }
}

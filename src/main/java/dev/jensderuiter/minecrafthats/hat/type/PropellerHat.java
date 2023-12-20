package dev.jensderuiter.minecrafthats.hat.type;

import dev.jensderuiter.minecrafthats.HatsPlugin;
import dev.jensderuiter.minecrafthats.hat.BaseHat;
import dev.jensderuiter.minecrafthats.hat.component.PropellerComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4d;
import org.joml.Vector3f;

public class PropellerHat extends BaseHat {

    private PropellerComponent propellerComponent;

    public PropellerHat(Player player) {
        super(player);

        // front piece
        this.addComponent(
                Material.RED_CARPET,
                new Vector(-0.1, 0.45, 0.35),
                0.3f,
                new AxisAngle4d(Math.toRadians(10), 1, 0 , 0)
        );
        this.addComponent(
                Material.RED_CARPET,
                new Vector(0.1, 0.45, 0.35),
                0.3f,
                new AxisAngle4d(Math.toRadians(10), 1, 0 , 0)
        );
        this.addComponent(
                Material.RED_CARPET,
                new Vector(-0.1, 0.5, 0.37),
                0.3f,
                new AxisAngle4d(Math.toRadians(45), 1, 0 , 0)
        );
        this.addComponent(
                Material.RED_CARPET,
                new Vector(0.1, 0.5, 0.37),
                0.3f,
                new AxisAngle4d(Math.toRadians(45), 1, 0 , 0)
        );

        this.addComponent(
                Material.RED_CARPET,
                new Vector(0, 0.63, 0),
                new Vector3f(0.48f, 0.3f, 0.48f),
                new AxisAngle4d(Math.toRadians(0), 1, 0 , 0)
        );

        this.addComponent(
                Material.RED_CARPET,
                new Vector(-0.3, 0.35, 0),
                new Vector3f(0.3f, 0.1f, 0.48f),
                new AxisAngle4d(Math.toRadians(90), 0, 0 , 1)
        );
        this.addComponent(
                Material.RED_CARPET,
                new Vector(0.2, 0.35, 0),
                new Vector3f(0.3f, 0.1f, 0.48f),
                new AxisAngle4d(Math.toRadians(90), 0, 0 , 1)
        );
        this.addComponent(
                Material.RED_CARPET,
                new Vector(0, 0.35, -0.2),
                new Vector3f(0.48f, 0.1f, 0.3f),
                new AxisAngle4d(Math.toRadians(90), 1, 0, 0)
        );

        this.addComponent(
                Material.REDSTONE_TORCH,
                new Vector(0, 0.6, 0),
                0.35f
        );

        propellerComponent = new PropellerComponent(
                this.initDisplay(
                        Material.STICK,
                        new Vector3f(0.5f, 0.7f, 0.5f),
                        new AxisAngle4d(Math.toRadians(0), 1, 1, 1)),
                this.getPlayer(),
                new Vector(0, 0.6, 0)
        );

        this.components.add(propellerComponent);

        this.spawn();
    }

    public void liftOff() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (propellerComponent.getSpeed() < 30) {
                    propellerComponent.setSpeed(propellerComponent.getSpeed() + 1);
                } else if (propellerComponent.getSpeed() == 30) {
                    player.addPotionEffect(new PotionEffect(
                            PotionEffectType.LEVITATION,
                            PotionEffect.INFINITE_DURATION,
                            0,
                            false, false, false
                    ));
                    this.cancel();
                }

            }
        }.runTaskTimer(HatsPlugin.getInstance(), 0, 2);
    }

}

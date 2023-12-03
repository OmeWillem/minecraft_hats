package dev.jensderuiter.minecrafthats.hat.component;

import dev.jensderuiter.minecrafthats.hat.HatComponent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class PropellerComponent extends HatComponent {

    private int tick;

    @Getter
    @Setter
    private int speed;

    public PropellerComponent(Display display, Player player, Vector offset) {
        super(display, player, offset);
        this.tick = 0;
        this.speed = 3;
    }

    @Override
    public void tick(double yaw, double pitch) {
        this.tick += this.speed;
        Transformation transformation = this.display.getTransformation();
        transformation.getLeftRotation().setAngleAxis(Math.toRadians(this.tick), 0, 1, 0);
        transformation.getRightRotation().setAngleAxis(Math.toRadians(90), 1, 0, 0);
        this.display.setTransformation(transformation);
        super.tick(yaw, pitch);
    }
}

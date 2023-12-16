package dev.jensderuiter.minecrafthats.hat.type;

import dev.jensderuiter.minecrafthats.hat.BaseHat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4d;

public class PartyHat extends BaseHat {
    public PartyHat(Player player) {
        super(player);

        for (int i = 0; i < 180; i += 15) {
            this.addComponent(
                    Material.POINTED_DRIPSTONE,
                    new Vector(0, 0.9, 0),
                    1.1f,
                    new AxisAngle4d(Math.toRadians(180), 1, 0, 0),
                    new AxisAngle4d(Math.toRadians(i), 0, 1, 0)
            );
        }

        this.spawn();
    }
}

package dev.jensderuiter.minecrafthats.hat;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface Hat {

    void spawn();
    void destroy();
    void tick(Location location);
    Player getPlayer();

}

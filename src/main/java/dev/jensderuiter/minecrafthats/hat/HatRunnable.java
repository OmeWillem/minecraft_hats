package dev.jensderuiter.minecrafthats.hat;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HatRunnable extends BukkitRunnable {

    private Hat hat;
    private Player player;

    public HatRunnable(Hat hat) {
        this.hat = hat;
        this.player = hat.getPlayer();
    }

    @Override
    public void run() {
        this.hat.tick(this.player.getLocation());
    }
}

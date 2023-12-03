package dev.jensderuiter.minecrafthats.listener;

import dev.jensderuiter.minecrafthats.HatsPlugin;
import dev.jensderuiter.minecrafthats.hat.Hat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Hat playerHat = HatsPlugin.playerHats.get(event.getPlayer());
        if (playerHat == null) return;
        playerHat.tick(event.getTo());
    }

}

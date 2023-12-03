package dev.jensderuiter.minecrafthats.listener;

import dev.jensderuiter.minecrafthats.HatsPlugin;
import dev.jensderuiter.minecrafthats.hat.Hat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Hat playerHat = HatsPlugin.playerHats.get(event.getPlayer());
        if (playerHat == null) return;
        playerHat.destroy();
        HatsPlugin.playerHats.remove(event.getPlayer());
    }

}

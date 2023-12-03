package dev.jensderuiter.minecrafthats;

import dev.jensderuiter.minecrafthats.hat.Hat;
import dev.jensderuiter.minecrafthats.listener.MoveListener;
import dev.jensderuiter.minecrafthats.listener.QuitListener;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class HatsPlugin extends JavaPlugin {

    public static HashMap<Player, Hat> playerHats;

    @Getter
    private static HatsPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        playerHats = new HashMap<>();

        getCommand("hat").setExecutor(new SpawnCommand());
        getCommand("liftoff").setExecutor(new LiftOffCommand());
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
    }

    @Override
    public void onDisable() {
        playerHats.values().forEach(Hat::destroy);
    }
}

package dev.jensderuiter.minecrafthats;

import dev.jensderuiter.minecrafthats.hat.Hat;
import dev.jensderuiter.minecrafthats.hat.type.PropellerHat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;

        Hat hat = new PropellerHat(player);
        HatsPlugin.playerHats.put(player, hat);

        return true;
    }
}

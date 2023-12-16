package dev.jensderuiter.minecrafthats;

import dev.jensderuiter.minecrafthats.hat.Hat;
import dev.jensderuiter.minecrafthats.hat.type.PartyHat;
import dev.jensderuiter.minecrafthats.hat.type.PropellerHat;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class SpawnCommand implements CommandExecutor {

    private static final Map<String, Class<? extends Hat>> hatTypes = Map.of(
            "propeller", PropellerHat.class,
            "party", PartyHat.class
    );

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;

        if (args.length < 1) {
            player.sendMessage("Je moet wel iets meegeven he");
            return true;
        }

        if (args[0].equals("remove")) {
            Hat hat = HatsPlugin.playerHats.get(player);
            if (hat == null) {
                player.sendMessage("Je had helemaal geen hoed");
            } else {
                hat.destroy();
                HatsPlugin.playerHats.remove(player);
                player.sendMessage("Hoed is weg");
            }
            return true;
        }

        Class<? extends Hat> hatType = hatTypes.get(args[0]);
        if (hatType == null) {
            player.sendMessage("Deze hoed bestaat niet makker");
            return true;
        }

        Hat hat = hatType.getConstructor(Player.class).newInstance(player);
        HatsPlugin.playerHats.put(player, hat);

        return true;
    }
}

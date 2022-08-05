package dev.aarow.home.commands.impl;

import dev.aarow.home.commands.BaseCommand;
import dev.aarow.home.commands.CommandInfo;
import dev.aarow.home.data.player.Profile;
import dev.aarow.home.data.player.handler.HomeHandler;
import dev.aarow.home.utility.chat.CC;
import dev.aarow.home.utility.helper.ThrowError;
import dev.aarow.home.utility.helper.types.ErrorType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "sethome", playerOnly = true)
public class SetHomeCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        Profile profile = plugin.getProfileManager().get(player);

        switch(args.length){
            case 0:
                profile.getHomes().put("default", player.getLocation());
                new HomeHandler(profile).save();

                player.sendMessage(CC.translate("&7[&aSUCCESS&7] &aSuccessfully set home on this location!"));
                return;
            case 1:
                profile.getHomes().put(args[0], player.getLocation());

                new HomeHandler(profile).save();
                return;
        }

        new ThrowError(player, "/sethome <home>", ErrorType.CORRECT_USAGE).throwIt();
    }
}

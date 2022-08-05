package dev.aarow.home.commands.impl;

import dev.aarow.home.commands.BaseCommand;
import dev.aarow.home.commands.CommandInfo;
import dev.aarow.home.data.player.Profile;
import dev.aarow.home.data.player.handler.HomeHandler;
import dev.aarow.home.utility.chat.CC;
import dev.aarow.home.utility.helper.ThrowError;
import dev.aarow.home.utility.helper.types.ErrorType;
import org.bukkit.entity.Player;

@CommandInfo(name = "home", playerOnly = true)
public class HomeCommand extends BaseCommand {

    @Override
    public void execute(Player player, String[] args) {
        Profile profile = plugin.getProfileManager().get(player);

        switch(args.length){
            case 0:
                profile.teleportToHome("default");
                return;
            case 1:
                profile.teleportToHome(args[0]);
                return;
        }

        new ThrowError(player, "/home <home>", ErrorType.CORRECT_USAGE);

    }
}

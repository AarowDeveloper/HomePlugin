package dev.aarow.home.data.player;

import dev.aarow.home.data.player.handler.HomeHandler;
import dev.aarow.home.utility.chat.CC;
import dev.aarow.home.utility.helper.ThrowError;
import dev.aarow.home.utility.helper.types.ErrorType;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

@Getter
public class Profile {

    private UUID uuid;

    private Map<String, Location> homes = new HashMap<>();

    public Profile(UUID uuid){
        this.uuid = uuid;

        new HomeHandler(this).load();
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    public void teleportToHome(String home){
        if(!homes.containsKey(home)){
            new ThrowError(getPlayer(), "There is no home with &4" + home + " &cname.", ErrorType.NULL);
            return;
        }

        getPlayer().teleport(homes.get(home));

        getPlayer().sendMessage(CC.translate("&7[&aSUCCESS&7] &aYou have been successfully teleported to your home!"));
    }
}

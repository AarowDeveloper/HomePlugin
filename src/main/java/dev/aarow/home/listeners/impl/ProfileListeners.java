package dev.aarow.home.listeners.impl;

import dev.aarow.home.listeners.ListenerAdapter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;

public class ProfileListeners extends ListenerAdapter {

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();

        plugin.getProfileManager().handle(player);
    }
}

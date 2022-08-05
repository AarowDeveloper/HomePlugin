package dev.aarow.home.listeners;

import dev.aarow.home.HomePlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerAdapter implements Listener {

    public HomePlugin plugin = HomePlugin.INSTANCE;

    public ListenerAdapter(){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}

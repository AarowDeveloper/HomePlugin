package dev.aarow.home.utility.general;

import dev.aarow.home.HomePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtility {

    public static Location getFromConfig(String path){
        HomePlugin plugin = HomePlugin.INSTANCE;

        World world = Bukkit.getWorld(plugin.getConfig().getString(path + ".WORLD"));
        double x = plugin.getConfig().getDouble(path + ".X");
        double y = plugin.getConfig().getDouble(path + ".Y");
        double z = plugin.getConfig().getDouble(path + ".Z");

        double yaw = 0;
        double pitch = 0;

        if(plugin.getConfig().contains(path + ".YAW") && plugin.getConfig().contains(path + ".PITCH")){
            yaw = plugin.getConfig().getDouble(path + ".YAW");
            pitch = plugin.getConfig().getDouble(path + ".PITCH");
        }

        return new Location(world, x, y, z, GeneralUtility.fromDouble(yaw), GeneralUtility.fromDouble(pitch));
    }

    public static void saveToConfig(String path, Location location){
        HomePlugin plugin = HomePlugin.INSTANCE;

        plugin.getConfig().set(path + ".WORLD", location.getWorld().getName());
        plugin.getConfig().set(path + ".X", location.getX());
        plugin.getConfig().set(path + ".Y", location.getY());
        plugin.getConfig().set(path + ".Z", location.getZ());
        plugin.getConfig().set(path + ".YAW", location.getYaw());
        plugin.getConfig().set(path + ".PITCH", location.getPitch());

        plugin.saveConfig();
    }
}

package dev.aarow.home.data.player.handler;

import dev.aarow.home.HomePlugin;
import dev.aarow.home.data.player.Profile;
import dev.aarow.home.utility.general.LocationUtility;
import lombok.AllArgsConstructor;
import org.bukkit.configuration.ConfigurationSection;

@AllArgsConstructor
public class HomeHandler {

    private Profile profile;

    public void load(){
        HomePlugin plugin = HomePlugin.INSTANCE;

        String path = "HOMES." + profile.getPlayer().getName();
        ConfigurationSection configurationSection = plugin.getConfig().getConfigurationSection(path);

        if(configurationSection == null) return;

        profile.getHomes().clear();

        configurationSection.getKeys(false).forEach(homeName -> {
            profile.getHomes().put(homeName, LocationUtility.getFromConfig(path + "." + homeName));
        });
    }

    public void save(){
        HomePlugin plugin = HomePlugin.INSTANCE;

        String path = "HOMES." + profile.getPlayer().getName();
        ConfigurationSection configurationSection = plugin.getConfig().getConfigurationSection(path);

        configurationSection.set(configurationSection.getCurrentPath(), null);

        profile.getHomes().keySet().forEach(homeName -> {
            LocationUtility.saveToConfig(path + "." + homeName, profile.getHomes().get(homeName));
        });

        plugin.saveConfig();
    }
}

package dev.aarow.home;

import dev.aarow.home.commands.impl.HomeCommand;
import dev.aarow.home.commands.impl.SetHomeCommand;
import dev.aarow.home.listeners.impl.ProfileListeners;
import dev.aarow.home.managers.impl.ProfileManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class HomePlugin extends JavaPlugin {

    public static HomePlugin INSTANCE;

    @Getter private ProfileManager profileManager;

    public void onEnable(){
        this.INSTANCE = this;
        this.registerConfiguration();

        this.profileManager = new ProfileManager();

        this.registerCommands();
        this.registerListeners();
    }

    public void registerConfiguration(){
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    protected void registerListeners(){
        new ProfileListeners();
    }

    protected void registerCommands(){
        new SetHomeCommand();
        new HomeCommand();
    }
}

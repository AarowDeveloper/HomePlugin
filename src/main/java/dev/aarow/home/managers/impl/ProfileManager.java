package dev.aarow.home.managers.impl;

import dev.aarow.home.data.player.Profile;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class ProfileManager {

    private Map<UUID, Profile> profiles = new HashMap<>();

    public void handle(Player player){
        this.profiles.put(player.getUniqueId(), new Profile(player.getUniqueId()));
    }

    public Profile get(Player player){
        return this.profiles.get(player.getUniqueId());
    }

    public Profile get(UUID uuid){
        return this.profiles.get(uuid);
    }
}

package dev.aarow.home.utility.helper;

import dev.aarow.home.utility.chat.CC;
import dev.aarow.home.utility.helper.types.ErrorType;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ThrowError {

    private Player player;
    private String error;
    private ErrorType errorType;


    public void throwIt(){
        player.sendMessage(CC.translate("&7[&cError&7] &c" + errorType.getPrefix() + error));
    }
}

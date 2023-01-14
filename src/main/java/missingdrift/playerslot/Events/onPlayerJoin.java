package missingdrift.playerslot.Events;

import missingdrift.playerslot.Playerslot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class onPlayerJoin implements Listener {
    private Plugin plugin = Playerslot.getPlugin(Playerslot.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        //Anti config broken
        if(plugin.getConfig().getInt("slot") >= 9 || plugin.getConfig().getInt("slot") <= 1) {
            plugin.getConfig().set("slot", 1);
            plugin.reloadConfig();
        }

        player.getInventory().setHeldItemSlot(plugin.getConfig().getInt("slot") - 1);
    }
}

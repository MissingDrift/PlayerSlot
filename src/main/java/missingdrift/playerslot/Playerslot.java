package missingdrift.playerslot;

import missingdrift.playerslot.Commands.MainCommand;
import missingdrift.playerslot.Events.onPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;


public final class Playerslot extends JavaPlugin implements Listener{
    public static Playerslot plugin;
    public static Playerslot instance;

    @Override
    public void onEnable() {
        instance = this;
        plugin = this;

        getServer().getPluginManager().registerEvents(this, this);

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);

        getCommand("playerslot").setExecutor(new MainCommand());

        System.out.println("\n  ____  _        _ __   _______ ____  ____  _     ___ _____  \n" +
                " |  _ \\| |      / \\\\ \\ / / ____|  _ \\/ ___|| |   / _ \\_   _| \n" +
                " | |_) | |     / _ \\\\ V /|  _| | |_) \\___ \\| |  | | | || |   \n" +
                " |  __/| |___ / ___ \\| | | |___|  _ < ___) | |__| |_| || |   \n" +
                " |_|   |_____/_/   \\_\\_| |_____|_| \\_\\____/|_____\\___/ |_| \n" +
                "\n" +
                "Version: 1.0.0\n" +
                "Author: MissingDrift");

    }

    @Override
    public void onDisable() {


    }
}

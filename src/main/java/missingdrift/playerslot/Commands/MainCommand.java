package missingdrift.playerslot.Commands;

import missingdrift.playerslot.Playerslot;
import missingdrift.playerslot.Utils.ANSI_COLOR;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MainCommand implements CommandExecutor {

    //class
    private Plugin plugin = Playerslot.getPlugin(Playerslot.class);

    //help command - player
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 0) {
                p.sendMessage("&8&m+--------------------------------------------+".replace("&", "§"));
                p.sendMessage("".replace("&", "§"));
                p.sendMessage("&dPlayerSlot &7- &aRunning &8(&71.0&8)".replace("&", "§"));
                p.sendMessage("&7Author: &eMissingDrift".replace("&", "§"));
                p.sendMessage("".replace("&", "§"));
                p.sendMessage("&e/ps &7= &fCheck if the plugin works".replace("&", "§"));
                p.sendMessage("&e/ps reload &7= &fReload the plugin.".replace("&", "§"));
                p.sendMessage("".replace("&", "§"));
                p.sendMessage("&8&m+--------------------------------------------+".replace("&", "§"));
            }

            //Reload command
            else if (args.length == 1) {
                if (args[0].toLowerCase() == "reload") {
                    this.plugin.reloadConfig();
                    this.plugin.saveConfig();
                    sender.sendMessage("§aReload complete!");
                    p.sendMessage("§aReload complete!");
                    System.out.println("Reload complete!");
                }
            } //help command - console
        } else if(sender instanceof ConsoleCommandSender){
            if(args.length == 0) {
                System.out.println(ANSI_COLOR.ANSI_RESET + "--------------------------------------------" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_RESET + "" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_PURPLE + "PlayerSlot" + ANSI_COLOR.ANSI_RESET + " - " + ANSI_COLOR.ANSI_GREEN + "Running " + ANSI_COLOR.ANSI_RESET + "on version" + ANSI_COLOR.ANSI_YELLOW + " 1.0.0" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_RESET + "Author:" + ANSI_COLOR.ANSI_YELLOW + " MissingDrift" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_RESET + "" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_YELLOW + "/ps" + ANSI_COLOR.ANSI_RESET + " = Check if the plugin works" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_YELLOW + "/ps reload" + ANSI_COLOR.ANSI_RESET + " = Reload the plugin" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_RESET + "" + ANSI_COLOR.ANSI_RESET);
                System.out.println(ANSI_COLOR.ANSI_RESET + "--------------------------------------------" + ANSI_COLOR.ANSI_RESET);
            }
        }
        return true;
    }
}

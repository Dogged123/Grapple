package dogged.grapple.commands;

import dogged.grapple.utilities.ItemMaker;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GrappleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        ItemStack grapple = ItemMaker.buildItem(Material.FISHING_ROD, "§c§lGrappling Hook");
        Player p = null;

        if (sender instanceof Player) {
            if (args.length == 0) {
                p = (Player) sender;
            }
        } else {
            if (args.length == 0) {
                sender.sendMessage("§cPlease specify a player to give the grapple to");
                return true;
            }
        }

        if (args.length != 0) {
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage("§c" + args[0] + " is not online");
                return true;
            } else {
                p = Bukkit.getPlayer(args[0]);
            }
        }

        if (p == null) return true;

        p.getInventory().addItem(grapple);
        return true;
    }
}

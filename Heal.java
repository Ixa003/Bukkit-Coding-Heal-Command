package General.Core.Commands.staff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "No compatible para consolas.");
            return true;
        }
        Player p = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (p.hasPermission("ixaessentials.heal"))
                if (args.length != 1) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Has sido curado");
                    p.sendMessage(ChatColor.GREEN + "Tu hambre ha sido saciado.");
                    p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                    return true;
                }
            if (target == null) {
                p.sendMessage(ChatColor.RED + "Jugador no localizado.");
                return true;
            }
            target.setHealth(20);
            target.setFoodLevel(20);
            target.sendMessage(ChatColor.GREEN + "Has sido curado");
            p.sendMessage(ChatColor.GREEN + "Has curado a " + target.getName());
        }
        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (p.hasPermission("ixaessentials.heal")) {
                if (args.length != 1) {
                    p.sendMessage(ChatColor.RED + "Uso: /feed <jugador>");
                    return true;
                }
                if (target == null) {
                    p.sendMessage(ChatColor.RED + "Jugador no localizado.");
                    return true;
                }
                target.setFoodLevel(20);
                target.sendMessage(ChatColor.GREEN + "Tu hambre ha sido saciado.");
                target.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
            }
        }
        return true;
    }
}
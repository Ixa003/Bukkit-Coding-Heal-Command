package General.Core;

import General.Core.Commands.staff.Heal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    PluginDescriptionFile pdf = getDescription();
    public String ver = pdf.getVersion();

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "El plugin heal ha sido activado correctamente.");


        getCommand("heal").setExecutor(new Heal());
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "El plugin heal ha sido desactivado.");
    }
}
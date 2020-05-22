package me.Nickedyerpants;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {     //what happens when plugin is enabled

        getLogger().info("First plugin starting up....");


    }


    @Override
    public void onDisable() {   //for when plugin is disabled
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("hello") && sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage("hello");

        }

        return true;

    }


}
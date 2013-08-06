package io.github.psgs.cooker;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Cooker extends JavaPlugin {

    private Logger logger;
    private Cooker plugin;

    public Cooker(Cooker plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {

        log(0, plugin.getName() + plugin.getDescription() + " is enabled!");

    }

    @Override
    public void onDisable() {

        log(0, plugin.getName() + plugin.getDescription() + " is disabled!");

    }

    public void setLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    public void log(int priority, String msg) {
        if (logger != null) {
            if (priority == 0) {
                logger.info(plugin.getName() + plugin.getDescription() + " " + msg);
            } else {
                if (priority == 1) {
                    logger.warning(plugin.getName() + plugin.getDescription() + " " + msg);
                } else {
                    if (priority == 2) {
                        logger.severe(plugin.getName() + plugin.getDescription() + " " + msg);
                    }
                }
            }
        }
    }

    public class CookerCommand implements CommandExecutor {

        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (command.getName().equalsIgnoreCase("cook")) {
                if (sender.hasPermission("cooker.cook")) {
                    Player p = Bukkit.getPlayer(sender.getName());
                    String sn = sender.getName();

                    ItemStack i = p.getItemInHand();

                    ItemStack cb = new ItemStack(Material.COOKED_BEEF);
                    ItemStack cc = new ItemStack(Material.COOKED_CHICKEN);
                    ItemStack cf = new ItemStack(Material.COOKED_FISH);
                    ItemStack cp = new ItemStack(Material.GRILLED_PORK);

                    if (i.equals(Material.RAW_BEEF)) {
                        p.setItemInHand(cb);
                        log(0, sn + " cooked Raw Beef!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                    }

                    if (i.equals(Material.RAW_CHICKEN)) {
                        p.setItemInHand(cc);
                        log(0, sn + " cooked Raw Chicken!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                    }

                    if (i.equals(Material.RAW_FISH)) {
                        p.setItemInHand(cf);
                        log(0, sn + " cooked Raw Fish!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                    }

                    if (i.equals(Material.PORK)) {
                        p.setItemInHand(cp);
                        log(0, sn + " cooked Raw Pork!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                    }
                }
            }
            return false;
        }
    }
}
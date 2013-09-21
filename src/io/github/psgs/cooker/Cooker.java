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

    public Cooker(Cooker plugin) {
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

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
                    System.out.println(sn + " cooked Raw Beef!");
                    sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                }

                if (i.equals(Material.RAW_CHICKEN)) {
                    p.setItemInHand(cc);
                    System.out.println(sn + " cooked Raw Chicken!");
                    sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                }

                if (i.equals(Material.RAW_FISH)) {
                    p.setItemInHand(cf);
                    System.out.println(sn + " cooked Raw Fish!");
                    sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                }

                if (i.equals(Material.PORK)) {
                    p.setItemInHand(cp);
                    System.out.println(sn + " cooked Raw Pork!");
                    sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                }
            }
        }
        return false;
    }
}
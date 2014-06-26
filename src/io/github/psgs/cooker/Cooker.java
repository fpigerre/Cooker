package io.github.psgs.cooker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Cooker extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cook")) {
            if (sender.hasPermission("cooker.cook")) {
                Player player = Bukkit.getPlayer(sender.getName());
                String senderName = sender.getName();

                ItemStack itemInHand = player.getItemInHand();
                int itemCount = itemInHand.getAmount();

                switch (itemInHand.getType()) {
                    case RAW_BEEF:
                        ItemStack cookedBeef = new ItemStack(Material.COOKED_BEEF, itemCount);
                        player.setItemInHand(cookedBeef);
                        this.getLogger().log(Level.INFO, senderName + " cooked " + itemCount + " Raw Beef!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                        break;

                    case RAW_CHICKEN:
                        ItemStack cookedChicken = new ItemStack(Material.COOKED_CHICKEN, itemCount);
                        player.setItemInHand(cookedChicken);
                        this.getLogger().log(Level.INFO, senderName + " cooked " + itemCount + " Raw Chicken!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                        break;

                    case RAW_FISH:
                        ItemStack cookedFish = new ItemStack(Material.COOKED_FISH, itemCount);
                        player.setItemInHand(cookedFish);
                        this.getLogger().log(Level.INFO, senderName + " cooked " + itemCount + " Raw Fish!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                        break;

                    case PORK:
                        ItemStack cookedPork = new ItemStack(Material.GRILLED_PORK, itemCount);
                        player.setItemInHand(cookedPork);
                        this.getLogger().log(Level.INFO, senderName + " cooked " + itemCount + " Raw Pork!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                        break;

                    case POTATO_ITEM:
                        ItemStack cookedPotato = new ItemStack(Material.BAKED_POTATO, itemCount);
                        player.setItemInHand(cookedPotato);
                        this.getLogger().log(Level.INFO, senderName + " cooked " + itemCount + " Potato!");
                        sender.sendMessage(ChatColor.GOLD + "Item Cooked!");
                        break;

                    default:
                        sender.sendMessage(ChatColor.GOLD + "[Cooker]" + ChatColor.RED + " The item you're holding can't be cooked!");
                        break;
                }
            }
        }
        return false;
    }
}
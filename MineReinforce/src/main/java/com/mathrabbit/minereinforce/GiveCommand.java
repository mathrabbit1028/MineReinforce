package com.mathrabbit.minereinforce;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

public class GiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.isOp()) {
                if (args.length == 2) {
                    if (args[0].equals("enchant")) {
                        ItemStack item = new MaterialData(Material.BOOK).toItemStack(Integer.parseInt(args[1]));
                        ItemMeta item_meta = item.getItemMeta();
                        item_meta.setDisplayName("마법 부여 주문서");
                        item_meta.setLore(Arrays.asList("아이템에 마법을 부여할 때 사용됩니다."));
                        item.setItemMeta(item_meta);
                        player.getInventory().addItem(item);
                    } else if (args[0].equals("anvil")) {
                        ItemStack item = new MaterialData(Material.PAPER).toItemStack(Integer.parseInt(args[1]));
                        ItemMeta item_meta = item.getItemMeta();
                        item_meta.setDisplayName("강화 주문서");
                        item_meta.setLore(Arrays.asList("아이템을 강화할 때 사용됩니다."));
                        item.setItemMeta(item_meta);
                        player.getInventory().addItem(item);
                    } else sender.sendMessage(ChatColor.RED + "/magic (enchant/anvil) (count) [Playername]");
                } else if (args.length == 3) {
                    if (Bukkit.getServer().getPlayer(args[2]) == null)
                        sender.sendMessage(ChatColor.RED + ("We can't find person " + args[2]));
                    else {
                        if (args[0].equals("enchant")) {
                            ItemStack item = new MaterialData(Material.BOOK).toItemStack(Integer.parseInt(args[1]));
                            ItemMeta item_meta = item.getItemMeta();
                            item_meta.setDisplayName("마법 부여 주문서");
                            item_meta.setLore(Arrays.asList("아이템에 마법을 부여할 때 사용됩니다."));
                            item.setItemMeta(item_meta);
                            Bukkit.getServer().getPlayer(args[2]).getInventory().addItem(item);
                        } else if (args[0].equals("anvil")) {
                            ItemStack item = new MaterialData(Material.PAPER).toItemStack(Integer.parseInt(args[1]));
                            ItemMeta item_meta = item.getItemMeta();
                            item_meta.setDisplayName("강화 주문서");
                            item_meta.setLore(Arrays.asList("아이템을 강화할 때 사용됩니다."));
                            item.setItemMeta(item_meta);
                            Bukkit.getServer().getPlayer(args[2]).getInventory().addItem(item);
                        } else sender.sendMessage(ChatColor.RED + "/magic (enchant/anvil) (count) [Playername]");
                    }
                } else sender.sendMessage(ChatColor.RED + "/magic (enchant/anvil) (count) [Playername]");
            }
            else sender.sendMessage(ChatColor.RED + "Only OP player can use this command.");
        }
        else sender.sendMessage(ChatColor.RED + "You can't use this command in console.");
        return false;
    }

}

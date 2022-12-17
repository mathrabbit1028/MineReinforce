package com.mathrabbit.minereinforce;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;

public class AnvilGUI {
    public static void item_set(Material material, String display_name, int stack, List<String> Lore, int loc, Inventory inv) {
        ItemStack item = new MaterialData(material).toItemStack(stack);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(display_name);
        item_meta.setLore(Lore);
        item.setItemMeta(item_meta);
        inv.setItem(loc, item);
    }

    public static void anvil_open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Anvil");

        for (int i = 0; i < 54; i++)
            if (i != 40) item_set(Material.WHITE_STAINED_GLASS_PANE, "", 1, Arrays.asList(), i, inv);

        int count = 0;
        ItemStack[] item_list = player.getOpenInventory().getBottomInventory().getContents();
        for (int i = 0; i < item_list.length; i++) {
            if (item_list[i] != null && item_list[i].getType() == Material.PAPER &&
                    item_list[i].getItemMeta().getDisplayName().equals("강화 주문서") &&
                    item_list[i].getItemMeta().getLore().contains("아이템을 강화할 때 사용됩니다."))
                count = count + item_list[i].getAmount();
        }
        item_set(Material.ANVIL, "Reinforce", 1, Arrays.asList("아이템을 우클릭해 강화하세요!"), 13, inv);
        item_set(Material.RED_STAINED_GLASS_PANE, "NOT ITEMS", 1, Arrays.asList(), 31, inv);

        player.openInventory(inv);
    }
}

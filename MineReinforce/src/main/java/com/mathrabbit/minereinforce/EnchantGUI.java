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

public class EnchantGUI {

    public static void item_set(Material material, String display_name, int stack, List<String> Lore, int loc, Inventory inv) {
        ItemStack item = new MaterialData(material).toItemStack(stack);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(display_name);
        item_meta.setLore(Lore);
        item.setItemMeta(item_meta);
        inv.setItem(loc, item);
    }

    public static void enchant_open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Enchant Table");

        for (int i = 0; i < 54; i++)
            if (i != 40) item_set(Material.WHITE_STAINED_GLASS_PANE, "", 1, Arrays.asList(), i, inv);

        item_set(Material.BOOK, "Level 1 Enchant", 1,
                Arrays.asList("1개의 [마법 부여 주문서]을 사용하여 1단계 인첸트를 부여합니다."), 10, inv);
        item_set(Material.BOOK, "Level 2 Enchant", 1,
                Arrays.asList("2개의 [마법 부여 주문서]을 사용하여 2단계 인첸트를 부여합니다."), 12, inv);
        item_set(Material.BOOK, "Level 3 Enchant", 1,
                Arrays.asList("4개의 [마법 부여 주문서]을 사용하여 3단계 인첸트를 부여합니다."), 14, inv);
        item_set(Material.BOOK, "Level 4 Enchant", 1,
                Arrays.asList("8개의 [마법 부여 주문서]을 사용하여 4단계 인첸트를 부여합니다."), 16, inv);

        int count = 0;
        ItemStack[] item_list = player.getOpenInventory().getBottomInventory().getContents();
        for (int i = 0; i < item_list.length; i++) {
            if (item_list[i] != null && item_list[i].getType() == Material.BOOK &&
                    item_list[i].getItemMeta().getDisplayName().equals("마법 부여 주문서") &&
                    item_list[i].getItemMeta().getLore().contains("아이템에 마법을 부여할 때 사용됩니다."))
                count = count + item_list[i].getAmount();
        }

        if (count >= 1) item_set(Material.RED_STAINED_GLASS_PANE, "UNACTIVATED", 1, Arrays.asList(), 19, inv);
        else item_set(Material.GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1, Arrays.asList(), 19, inv);
        if (count >= 2) item_set(Material.RED_STAINED_GLASS_PANE, "UNACTIVATED", 1, Arrays.asList(), 21, inv);
        else item_set(Material.GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1, Arrays.asList(), 21, inv);
        if (count >= 4) item_set(Material.RED_STAINED_GLASS_PANE, "UNACTIVATED", 1, Arrays.asList(), 23, inv);
        else item_set(Material.GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1, Arrays.asList(), 23, inv);
        if (count >= 8) item_set(Material.RED_STAINED_GLASS_PANE, "UNACTIVATED", 1, Arrays.asList(), 25, inv);
        else item_set(Material.GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1, Arrays.asList(), 25, inv);

        player.openInventory(inv);
    }

}

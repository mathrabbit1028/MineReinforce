package com.mathrabbit.minereinforce;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static org.bukkit.Material.*;
import static org.bukkit.Material.GRAY_STAINED_GLASS_PANE;

public class AnvilEvent implements Listener {

    public static ItemStack add_lore(ItemStack item, int level) {
        ItemMeta item_meta = item.getItemMeta();
        if (level == 10) item_meta.setLore(Arrays.asList(ChatColor.YELLOW + "★★★★★★★★★★"));
        else {
            String star = "";
            for (int i = 0; i < 10; i++) {
                if (i < level) star = star + "★";
                else star = star + "☆";
            }
            item_meta.setLore(Arrays.asList(ChatColor.YELLOW + star,
                    "필요 주문서: " + Integer.toString(level + 1) + "개",
                    "강화 확률: " + Integer.toString(100 - level * 10) + "%",
                    "실패 확률: " + Integer.toString(level * (10 - level)) + "%",
                    //"하락 확률: " + Integer.toString(0) + "%",
                    "파괴 확률: " + Integer.toString(level * level) + "%"));
        }
        item.setItemMeta(item_meta);
        return item;
    }

    public static ItemStack increase_attribute(ItemStack item, int level) {
        if (item.getType() == DIAMOND_SWORD || item.getType() == GOLDEN_SWORD || item.getType() == IRON_SWORD ||
                item.getType() == NETHERITE_SWORD || item.getType() == STONE_SWORD || item.getType() == WOODEN_SWORD) {
            ItemMeta item_meta = item.getItemMeta();
            AttributeModifier attack_speed = new AttributeModifier(UUID.randomUUID(), "generic_attack_speed",
                    0.1 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            item_meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
            item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attack_speed);
            attack_speed = new AttributeModifier(UUID.randomUUID(), "generic_attack_speed",
                    0.1 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
            item_meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
            item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attack_speed);
            item.setItemMeta(item_meta);
        }
        if (item.getType() == DIAMOND_HELMET || item.getType() == GOLDEN_HELMET || item.getType() == IRON_HELMET ||
                item.getType() == NETHERITE_HELMET || item.getType() == LEATHER_HELMET) {
            ItemMeta item_meta = item.getItemMeta();
            AttributeModifier armor_toughness = new AttributeModifier(UUID.randomUUID(), "generic_armor_toughness",
                    1 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            item_meta.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS);
            item_meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armor_toughness);
            item.setItemMeta(item_meta);
        }
        if (item.getType() == DIAMOND_CHESTPLATE || item.getType() == GOLDEN_CHESTPLATE || item.getType() == IRON_CHESTPLATE ||
                item.getType() == NETHERITE_CHESTPLATE || item.getType() == LEATHER_CHESTPLATE) {
            ItemMeta item_meta = item.getItemMeta();
            AttributeModifier max_health = new AttributeModifier(UUID.randomUUID(), "generic_max_health",
                    1 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            item_meta.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH);
            item_meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, max_health);
            item.setItemMeta(item_meta);
        }
        if (item.getType() == DIAMOND_LEGGINGS || item.getType() == GOLDEN_LEGGINGS || item.getType() == IRON_LEGGINGS ||
                item.getType() == NETHERITE_LEGGINGS || item.getType() == LEATHER_LEGGINGS) {
            ItemMeta item_meta = item.getItemMeta();
            AttributeModifier knockback_resistance = new AttributeModifier(UUID.randomUUID(), "generic_knockback_resistance",
                    0.5 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            item_meta.removeAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE);
            item_meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockback_resistance);
            item.setItemMeta(item_meta);
        }
        if (item.getType() == DIAMOND_BOOTS || item.getType() == GOLDEN_BOOTS || item.getType() == IRON_BOOTS ||
                item.getType() == NETHERITE_BOOTS || item.getType() == LEATHER_BOOTS) {
            ItemMeta item_meta = item.getItemMeta();
            AttributeModifier movement_speed = new AttributeModifier(UUID.randomUUID(), "generic_movement_speed",
                    0.01 * level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            item_meta.removeAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED);
            item_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movement_speed);
            item.setItemMeta(item_meta);
        }
        return item;
    }

    public ItemStack make_reinforce(ItemStack item, int level) {
        double random_value = Math.random();
        if (random_value >= (double)(level * 0.1)) return add_lore(increase_attribute(item, level + 1), level + 1);
        else if (random_value >= (double)(level * level * 0.01)) return item;
        //else if (random_value >= (double)(level * 0.01)) return add_lore(item, level - 1);
        else return null;
    }

    public static ItemStack remove_lore(ItemStack item) {
        int level = get_reinforce_level(item);
        ItemMeta item_meta = item.getItemMeta();
        String star = "";
        for (int i = 0; i < 10; i++) {
            if (i < level) star = star + "★";
            else star = star + "☆";
        }
        item_meta.setLore(Arrays.asList(ChatColor.YELLOW + star));
        item.setItemMeta(item_meta);
        return item;
    }

    public static int get_enchant_value(ItemStack item) {
        int val = 0;
        for (int j = 0; j < 13; j++) {
            if (item.getEnchantments().containsKey(EnchantEvent.val1_enchant[j]) && item.getEnchantments().get(EnchantEvent.val1_enchant[j]) == EnchantEvent.val1_level[j]) {
                val = val + 1;
            }
        }
        for (int j = 0; j < 25; j++) {
            if (item.getEnchantments().containsKey(EnchantEvent.val2_enchant[j]) &&
                    item.getEnchantments().get(EnchantEvent.val2_enchant[j]) == EnchantEvent.val2_level[j]) {
                val = val + 2;
            }
        }
        for (int j = 0; j < 31; j++) {
            if (item.getEnchantments().containsKey(EnchantEvent.val3_enchant[j]) &&
                    item.getEnchantments().get(EnchantEvent.val3_enchant[j]) == EnchantEvent.val3_level[j]) {
                val = val + 3;
            }
        }
        for (int j = 0; j < 28; j++) {
            if (item.getEnchantments().containsKey(EnchantEvent.val4_enchant[j]) &&
                    item.getEnchantments().get(EnchantEvent.val4_enchant[j]) == EnchantEvent.val4_level[j]) {
                val = val + 4;
            }
        }
        for (int j = 0; j < 14; j++) {
            if (item.getEnchantments().containsKey(EnchantEvent.val5_enchant[j]) &&
                    item.getEnchantments().get(EnchantEvent.val5_enchant[j]) == EnchantEvent.val5_level[j]) {
                val = val + 5;
            }
        }
        return val;
    }

    public static int get_reinforce_level(ItemStack item) {
        int level = 0;
        if (item.getItemMeta().hasLore()) {
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "☆☆☆☆☆☆☆☆☆☆"))
                level = 0;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★☆☆☆☆☆☆☆☆☆"))
                level = 1;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★☆☆☆☆☆☆☆☆"))
                level = 2;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★☆☆☆☆☆☆☆"))
                level = 3;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★☆☆☆☆☆☆"))
                level = 4;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★☆☆☆☆☆"))
                level = 5;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★☆☆☆☆"))
                level = 6;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★☆☆☆"))
                level = 7;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★☆☆"))
                level = 8;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★★☆"))
                level = 9;
            if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★★★"))
                level = 10;
        }
        return level;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                (event.getClickedBlock().getType() == ANVIL ||
                        event.getClickedBlock().getType() == CHIPPED_ANVIL ||
                        event.getClickedBlock().getType() == DAMAGED_ANVIL)) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            AnvilGUI gui = new AnvilGUI();
            gui.anvil_open(player);
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();

        if (event.getClickedInventory().getItem(13) != null &&
                event.getClickedInventory().getItem(13).getItemMeta().getLore() != null &&
                event.getClickedInventory().getItem(13).getItemMeta().getLore().
                        contains("아이템을 우클릭해 강화하세요!")) {
            if (event.getSlot() != 40) event.setCancelled(true);

            int count = 0, level = 0;
            ItemStack[] item_list = player.getOpenInventory().getBottomInventory().getContents();
            for (int i = 0; i < item_list.length; i++) {
                if (item_list[i] != null && item_list[i].getType() == Material.PAPER &&
                        item_list[i].getItemMeta().getDisplayName().equals("강화 주문서") &&
                        item_list[i].getItemMeta().hasLore() &&
                        item_list[i].getItemMeta().getLore().contains("아이템을 강화할 때 사용됩니다."))
                    count = count + item_list[i].getAmount();
            }

            if (event.getClickedInventory().getItem(40) == null) {
                AnvilGUI.item_set(Material.RED_STAINED_GLASS_PANE, "NOT ITEMS", 1,
                        Arrays.asList(), 31, event.getClickedInventory());
            } else {
                ItemStack item = event.getClickedInventory().getItem(40);
                if (item.getItemMeta().getLore() == null) {
                    level = 0;
                    event.getClickedInventory().setItem(40, add_lore(item, 0));
                    if (count < 1) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★☆☆☆☆☆☆☆☆☆")) {
                    level = 1;
                    event.getClickedInventory().setItem(40, add_lore(item, 1));
                    if (count < 2) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★☆☆☆☆☆☆☆☆")) {
                    level = 2;
                    event.getClickedInventory().setItem(40, add_lore(item, 2));
                    if (count < 3) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★☆☆☆☆☆☆☆")) {
                    level = 3;
                    event.getClickedInventory().setItem(40, add_lore(item, 3));
                    if (count < 4) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★☆☆☆☆☆☆")) {
                    level = 4;
                    event.getClickedInventory().setItem(40, add_lore(item, 4));
                    event.getClickedInventory().setItem(40, item);
                    if (count < 5) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★☆☆☆☆☆")) {
                    level = 5;
                    event.getClickedInventory().setItem(40, add_lore(item, 5));
                    if (count < 6) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★☆☆☆☆")) {
                    level = 6;
                    event.getClickedInventory().setItem(40, add_lore(item, 6));
                    if (count < 7) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★☆☆☆")) {
                    level = 7;
                    event.getClickedInventory().setItem(40, add_lore(item, 7));
                    if (count < 8) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★☆☆")) {
                    level = 8;
                    event.getClickedInventory().setItem(40, add_lore(item, 8));
                    if (count < 9) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★★☆")) {
                    level = 9;
                    event.getClickedInventory().setItem(40, add_lore(item, 9));
                    if (count < 10) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                } else if (item.getItemMeta().getLore().contains(ChatColor.YELLOW + "★★★★★★★★★★")) {
                    level = 10;
                    event.getClickedInventory().setItem(40, add_lore(item, 10));
                    AnvilGUI.item_set(BLUE_STAINED_GLASS_PANE, "FULL REINFORCE", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                } else {
                    level = 0;
                    event.getClickedInventory().setItem(40, add_lore(item, 0));
                    if (count < 1) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                            Arrays.asList(), 31, event.getClickedInventory());
                    if (get_enchant_value(item) < 2 * level + 2)
                        AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                Arrays.asList(), 31, event.getClickedInventory());
                }
            }
            if (event.getSlot() == 40) {
                if (event.getClick() == ClickType.RIGHT) {
                    event.setCancelled(true);
                    if (event.getClickedInventory().getItem(40) != null) {
                        ItemStack item = new MaterialData(Material.PAPER).toItemStack(1);
                        ItemMeta item_meta = item.getItemMeta();
                        item_meta.setDisplayName("강화 주문서");
                        item_meta.setLore(Arrays.asList("아이템을 강화할 때 사용됩니다."));
                        item.setItemMeta(item_meta);

                        if (event.getClickedInventory().getItem(31).getType() == Material.GREEN_STAINED_GLASS_PANE) {

                            event.getClickedInventory().setItem(40,
                                    make_reinforce((event.getClickedInventory().getItem(40)), level));
                            item.setAmount(level + 1);
                            player.getOpenInventory().getBottomInventory().removeItem(item);
                            count = count - level - 1;
                            if (event.getClickedInventory().getItem(40) == null)
                                AnvilGUI.item_set(Material.RED_STAINED_GLASS_PANE, "NOT ITEMS", 1,
                                        Arrays.asList(), 31, event.getClickedInventory());
                            else {
                                ItemStack result_item = event.getClickedInventory().getItem(40);
                                level = get_reinforce_level(result_item);
                                if (count < level + 1) AnvilGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                                        Arrays.asList(), 31, event.getClickedInventory());
                                else AnvilGUI.item_set(GREEN_STAINED_GLASS_PANE, "ENOUGH", 1,
                                        Arrays.asList(), 31, event.getClickedInventory());
                                if (get_enchant_value(result_item) < 2 * level + 2)
                                    AnvilGUI.item_set(ORANGE_STAINED_GLASS_PANE, "NOT ENOUGH ENCHANT", 1,
                                        Arrays.asList(), 31, event.getClickedInventory());
                                if (level == 10) AnvilGUI.item_set(BLUE_STAINED_GLASS_PANE, "FULL REINFORCE", 1,
                                        Arrays.asList(), 31, event.getClickedInventory());

                            }
                        }
                    }
                }
                else event.setCurrentItem(remove_lore(event.getCurrentItem()));
            }
        }
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        if (event.getInventory().getItem(13) != null &&
                event.getInventory().getItem(13).getItemMeta().getLore() != null &&
                event.getInventory().getItem(13).getItemMeta().getLore().
                        contains("아이템을 우클릭해 강화하세요!")) {
            if (event.getInventory().getItem(40) != null)
                event.getPlayer().getInventory().addItem(remove_lore(event.getInventory().getItem(40)));
        }
    }
}

package com.mathrabbit.minereinforce;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.Random;

import static org.bukkit.Material.*;

public class EnchantEvent implements Listener {

    static  Enchantment[] val1_enchant = new Enchantment[]{
            Enchantment.ARROW_DAMAGE,
            Enchantment.PROTECTION_ENVIRONMENTAL,
            Enchantment.PROTECTION_EXPLOSIONS,
            Enchantment.PROTECTION_FIRE,
            Enchantment.PROTECTION_PROJECTILE,
            Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_ARTHROPODS,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.DIG_SPEED,
            Enchantment.IMPALING,
            Enchantment.LOYALTY,
            Enchantment.PIERCING,
            Enchantment.RIPTIDE
    };
    static Enchantment[] val2_enchant = new Enchantment[]{
            Enchantment.ARROW_DAMAGE,
            Enchantment.PROTECTION_ENVIRONMENTAL,
            Enchantment.PROTECTION_EXPLOSIONS,
            Enchantment.PROTECTION_FIRE,
            Enchantment.PROTECTION_PROJECTILE,
            Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_ARTHROPODS,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.DIG_SPEED,
            Enchantment.IMPALING,
            Enchantment.LOYALTY,
            Enchantment.PIERCING,
            Enchantment.RIPTIDE,
            Enchantment.DEPTH_STRIDER,
            Enchantment.PROTECTION_FALL,
            Enchantment.FROST_WALKER,
            Enchantment.OXYGEN,
            Enchantment.LOOT_BONUS_BLOCKS,
            Enchantment.KNOCKBACK,
            Enchantment.LUCK,
            Enchantment.LURE,
            Enchantment.SWEEPING_EDGE,
            Enchantment.ARROW_KNOCKBACK,
            Enchantment.DURABILITY,
            Enchantment.SOUL_SPEED
    };
    static Enchantment[] val3_enchant = new Enchantment[]{
            Enchantment.ARROW_DAMAGE,
            Enchantment.PROTECTION_ENVIRONMENTAL,
            Enchantment.PROTECTION_EXPLOSIONS,
            Enchantment.PROTECTION_FIRE,
            Enchantment.PROTECTION_PROJECTILE,
            Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_ARTHROPODS,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.DIG_SPEED,
            Enchantment.IMPALING,
            Enchantment.LOYALTY,
            Enchantment.PIERCING,
            Enchantment.RIPTIDE,
            Enchantment.DEPTH_STRIDER,
            Enchantment.PROTECTION_FALL,
            Enchantment.OXYGEN,
            Enchantment.LOOT_BONUS_BLOCKS,
            Enchantment.LUCK,
            Enchantment.LURE,
            Enchantment.SWEEPING_EDGE,
            Enchantment.ARROW_KNOCKBACK,
            Enchantment.DURABILITY,
            Enchantment.WATER_WORKER,
            Enchantment.THORNS,
            Enchantment.FIRE_ASPECT,
            Enchantment.LOOT_BONUS_MOBS,
            Enchantment.SILK_TOUCH,
            Enchantment.QUICK_CHARGE,
            Enchantment.BINDING_CURSE,
            Enchantment.VANISHING_CURSE,
            Enchantment.SOUL_SPEED
    };
    static Enchantment[] val4_enchant = new Enchantment[]{
            Enchantment.ARROW_DAMAGE,
            Enchantment.PROTECTION_ENVIRONMENTAL,
            Enchantment.PROTECTION_EXPLOSIONS,
            Enchantment.PROTECTION_FIRE,
            Enchantment.PROTECTION_PROJECTILE,
            Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_ARTHROPODS,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.DIG_SPEED,
            Enchantment.IMPALING,
            Enchantment.PIERCING,
            Enchantment.DEPTH_STRIDER,
            Enchantment.PROTECTION_FALL,
            Enchantment.FROST_WALKER,
            Enchantment.OXYGEN,
            Enchantment.LOOT_BONUS_BLOCKS,
            Enchantment.KNOCKBACK,
            Enchantment.LUCK,
            Enchantment.LURE,
            Enchantment.SWEEPING_EDGE,
            Enchantment.ARROW_KNOCKBACK,
            Enchantment.DURABILITY,
            Enchantment.THORNS,
            Enchantment.LOOT_BONUS_MOBS,
            Enchantment.QUICK_CHARGE,
            Enchantment.CHANNELING,
            Enchantment.ARROW_FIRE,
            Enchantment.SOUL_SPEED
    };
    static Enchantment[] val5_enchant = new Enchantment[]{
            Enchantment.ARROW_DAMAGE,
            Enchantment.DAMAGE_ALL,
            Enchantment.DAMAGE_ARTHROPODS,
            Enchantment.DAMAGE_UNDEAD,
            Enchantment.DIG_SPEED,
            Enchantment.IMPALING,
            Enchantment.PROTECTION_FALL,
            Enchantment.THORNS,
            Enchantment.LOOT_BONUS_MOBS,
            Enchantment.QUICK_CHARGE,
            Enchantment.FIRE_ASPECT,
            Enchantment.ARROW_INFINITE,
            Enchantment.MULTISHOT,
            Enchantment.MENDING
    };

    static int[] val1_level = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int[] val2_level = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int[] val3_level = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2};
    static int[] val4_level = new int[] {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 2, 3, 3, 2, 3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 3};
    static int[] val5_level = new int[] {5, 5, 5, 5, 5, 5, 4, 3, 3, 3, 2, 1, 1, 1};

    public ItemStack make_enchant(ItemStack item, int val) {
        if (val == 0) return item;

        int use_val = Math.min(1 + (int)(Math.random() * val), 5);
        if (use_val == 1) {
            int idx = (int)(Math.random() * 13);
            item.addUnsafeEnchantment(val1_enchant[idx], val1_level[idx]);
        } else if (use_val == 2) {
            int idx = (int)(Math.random() * 25);
            item.addUnsafeEnchantment(val2_enchant[idx], val2_level[idx]);
        } else if (use_val == 3) {
            int idx = (int)(Math.random() * 31);
            item.addUnsafeEnchantment(val3_enchant[idx], val3_level[idx]);
        } else if (use_val == 4) {
            int idx = (int)(Math.random() * 28);
            item.addUnsafeEnchantment(val4_enchant[idx], val4_level[idx]);
        } else if (use_val == 5) {
            int idx = (int)(Math.random() * 14);
            item.addUnsafeEnchantment(val5_enchant[idx], val5_level[idx]);
        }
        return make_enchant(item, val - use_val);
    }

    public ItemStack clear_enchant(ItemStack item) {
        item.removeEnchantment(Enchantment.ARROW_DAMAGE);
        item.removeEnchantment(Enchantment.ARROW_FIRE);
        item.removeEnchantment(Enchantment.ARROW_INFINITE);
        item.removeEnchantment(Enchantment.ARROW_KNOCKBACK);
        item.removeEnchantment(Enchantment.BINDING_CURSE);
        item.removeEnchantment(Enchantment.CHANNELING);
        item.removeEnchantment(Enchantment.DAMAGE_ALL);
        item.removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
        item.removeEnchantment(Enchantment.DAMAGE_UNDEAD);
        item.removeEnchantment(Enchantment.DEPTH_STRIDER);
        item.removeEnchantment(Enchantment.DIG_SPEED);
        item.removeEnchantment(Enchantment.DURABILITY);
        item.removeEnchantment(Enchantment.FIRE_ASPECT);
        item.removeEnchantment(Enchantment.FROST_WALKER);
        item.removeEnchantment(Enchantment.IMPALING);
        item.removeEnchantment(Enchantment.KNOCKBACK);
        item.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
        item.removeEnchantment(Enchantment.LOOT_BONUS_MOBS);
        item.removeEnchantment(Enchantment.LOYALTY);
        item.removeEnchantment(Enchantment.LUCK);
        item.removeEnchantment(Enchantment.LURE);
        item.removeEnchantment(Enchantment.MENDING);
        item.removeEnchantment(Enchantment.MULTISHOT);
        item.removeEnchantment(Enchantment.OXYGEN);
        item.removeEnchantment(Enchantment.PIERCING);
        item.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
        item.removeEnchantment(Enchantment.PROTECTION_FALL);
        item.removeEnchantment(Enchantment.PROTECTION_EXPLOSIONS);
        item.removeEnchantment(Enchantment.PROTECTION_FIRE);
        item.removeEnchantment(Enchantment.PROTECTION_PROJECTILE);
        item.removeEnchantment(Enchantment.QUICK_CHARGE);
        item.removeEnchantment(Enchantment.RIPTIDE);
        item.removeEnchantment(Enchantment.SILK_TOUCH);
        item.removeEnchantment(Enchantment.SOUL_SPEED);
        item.removeEnchantment(Enchantment.SWEEPING_EDGE);
        item.removeEnchantment(Enchantment.THORNS);
        item.removeEnchantment(Enchantment.VANISHING_CURSE);
        item.removeEnchantment(Enchantment.WATER_WORKER);
        return item;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            EnchantGUI gui = new EnchantGUI();
            gui.enchant_open(player);
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        if (event.getClickedInventory().getItem(10) != null &&
                event.getClickedInventory().getItem(10).getItemMeta().getLore() != null &&
                event.getClickedInventory().getItem(10).getItemMeta().getLore().
                        contains("1개의 [마법 부여 주문서]을 사용하여 1단계 인첸트를 부여합니다.")) {
            if (event.getSlot() != 40) event.setCancelled(true);

            int count = 0;
            ItemStack[] item_list = player.getOpenInventory().getBottomInventory().getContents();
            for (int i = 0; i < item_list.length; i++) {
                if (item_list[i] != null && item_list[i].getType() == Material.BOOK &&
                        item_list[i].getItemMeta().getDisplayName().equals("마법 부여 주문서") &&
                        item_list[i].getItemMeta().getLore().contains("아이템에 마법을 부여할 때 사용됩니다."))
                    count = count + item_list[i].getAmount();
            }
            if (count < 1) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                    Arrays.asList(), 19, event.getClickedInventory());
            if (count < 2) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                    Arrays.asList(), 21, event.getClickedInventory());
            if (count < 4) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                    Arrays.asList(), 23, event.getClickedInventory());
            if (count < 8) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                    Arrays.asList(), 25, event.getClickedInventory());

            if (event.getSlot() == 19) {
                if (count >= 1) EnchantGUI.item_set(GREEN_STAINED_GLASS_PANE, "ACTIVATED", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                if (count >= 2) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                if (count >= 4) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                if (count >= 8) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
            }
            if (event.getSlot() == 21) {
                if (count >= 1) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                if (count >= 2) EnchantGUI.item_set(GREEN_STAINED_GLASS_PANE, "ACTIVATED", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                if (count >= 4) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                if (count >= 8) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
            }
            if (event.getSlot() == 23) {
                if (count >= 1) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                if (count >= 2) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                if (count >= 4) EnchantGUI.item_set(GREEN_STAINED_GLASS_PANE, "ACTIVATED", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                if (count >= 8) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
            }
            if (event.getSlot() == 25) {
                if (count >= 1) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 19, event.getClickedInventory());
                if (count >= 2) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 21, event.getClickedInventory());
                if (count >= 4) EnchantGUI.item_set(RED_STAINED_GLASS_PANE, "UNACTIVATED", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 23, event.getClickedInventory());
                if (count >= 8) EnchantGUI.item_set(GREEN_STAINED_GLASS_PANE, "ACTIVATED", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
                else EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                        Arrays.asList(), 25, event.getClickedInventory());
            }

            if (event.getSlot() == 40) {
                if (event.getClick() == ClickType.RIGHT) {
                    event.setCancelled(true);
                    if (event.getClickedInventory().getItem(40) != null) {
                        ItemStack item = new MaterialData(Material.BOOK).toItemStack(1);
                        ItemMeta item_meta = item.getItemMeta();
                        item_meta.setDisplayName("마법 부여 주문서");
                        item_meta.setLore(Arrays.asList("아이템에 마법을 부여할 때 사용됩니다."));
                        item.setItemMeta(item_meta);

                        Random random = new Random();

                        if (event.getClickedInventory().getItem(19).getType() == Material.GREEN_STAINED_GLASS_PANE) {
                            ItemStack result_item = make_enchant(clear_enchant(event.getClickedInventory().getItem(40)),
                                    Math.max(1, Math.min(5, (int)random.nextGaussian(3, 1))));
                            int level = AnvilEvent.get_reinforce_level(result_item);
                            int val = AnvilEvent.get_enchant_value(result_item);
                            if (val < 2 * level)
                                result_item = AnvilEvent.remove_lore(AnvilEvent.add_lore(
                                        AnvilEvent.increase_attribute(result_item, val / 2),val / 2));
                            event.getClickedInventory().setItem(40, result_item);

                            item.setAmount(1);
                            player.getOpenInventory().getBottomInventory().removeItem(item);
                            count = count - 1;
                        }
                        if (event.getClickedInventory().getItem(21).getType() == Material.GREEN_STAINED_GLASS_PANE) {
                            ItemStack result_item = make_enchant(clear_enchant(event.getClickedInventory().getItem(40)),
                                    Math.max(1, Math.min(11, (int)random.nextGaussian(6, 2))));
                            int level = AnvilEvent.get_reinforce_level(result_item);
                            int val = AnvilEvent.get_enchant_value(result_item);
                            if (val < 2 * level)
                                result_item = AnvilEvent.remove_lore(AnvilEvent.add_lore(
                                        AnvilEvent.increase_attribute(result_item, val / 2),val / 2));
                            event.getClickedInventory().setItem(40, result_item);

                            item.setAmount(2);
                            player.getOpenInventory().getBottomInventory().removeItem(item);
                            count = count - 2;
                        }
                        if (event.getClickedInventory().getItem(23).getType() == Material.GREEN_STAINED_GLASS_PANE) {
                            ItemStack result_item = make_enchant(clear_enchant(event.getClickedInventory().getItem(40)),
                                    Math.max(1, Math.min(17, (int)random.nextGaussian(9, 3))));
                            int level = AnvilEvent.get_reinforce_level(result_item);
                            int val = AnvilEvent.get_enchant_value(result_item);
                            if (val < 2 * level)
                                result_item = AnvilEvent.remove_lore(AnvilEvent.add_lore(
                                        AnvilEvent.increase_attribute(result_item, val / 2),val / 2));
                            event.getClickedInventory().setItem(40, result_item);

                            item.setAmount(4);
                            player.getOpenInventory().getBottomInventory().removeItem(item);
                            count = count - 4;
                        }
                        if (event.getClickedInventory().getItem(25).getType() == Material.GREEN_STAINED_GLASS_PANE) {
                            ItemStack result_item = make_enchant(clear_enchant(event.getClickedInventory().getItem(40)),
                                    Math.max(1, Math.min(23, (int)random.nextGaussian(12, 4))));
                            int level = AnvilEvent.get_reinforce_level(result_item);
                            int val = AnvilEvent.get_enchant_value(result_item);
                            if (val < 2 * level)
                                result_item = AnvilEvent.remove_lore(AnvilEvent.add_lore(
                                        AnvilEvent.increase_attribute(result_item, val / 2),val / 2));
                            event.getClickedInventory().setItem(40, result_item);

                            item.setAmount(8);
                            player.getOpenInventory().getBottomInventory().removeItem(item);
                            count = count - 8;
                        }

                        if (count < 1) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                                Arrays.asList(), 19, event.getClickedInventory());
                        if (count < 2) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                                Arrays.asList(), 21, event.getClickedInventory());
                        if (count < 4) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                                Arrays.asList(), 23, event.getClickedInventory());
                        if (count < 8) EnchantGUI.item_set(GRAY_STAINED_GLASS_PANE, "NOT ENOUGH", 1,
                                Arrays.asList(), 25, event.getClickedInventory());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        if (event.getInventory().getItem(10) != null &&
                event.getInventory().getItem(10).getItemMeta().getLore() != null &&
                event.getInventory().getItem(10).getItemMeta().getLore().
                        contains("1개의 [마법 부여 주문서]을 사용하여 1단계 인첸트를 부여합니다."))
            if (event.getInventory().getItem(40) != null)
                event.getPlayer().getInventory().addItem(event.getInventory().getItem(40));
    }
}

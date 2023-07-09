package com.mathrabbit.minereinforce;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class MineReinforce extends JavaPlugin {

    public ItemStack return_enchant(int cnt) {
        ItemStack item = new MaterialData(Material.BOOK).toItemStack(cnt);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName("마법 부여 주문서");
        item_meta.setLore(Arrays.asList("아이템에 마법을 부여할 때 사용됩니다."));
        item.setItemMeta(item_meta);
        return item;
    }

    public ItemStack return_anvil(int cnt) {
        ItemStack item = new MaterialData(Material.PAPER).toItemStack(cnt);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName("강화 주문서");
        item_meta.setLore(Arrays.asList("아이템을 강화할 때 사용됩니다."));
        item.setItemMeta(item_meta);
        return item;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("magic").setExecutor(new GiveCommand());

        getServer().getPluginManager().registerEvents(new AnvilEvent(), this);
        getServer().getPluginManager().registerEvents(new EnchantEvent(), this);

        ShapedRecipe enchant_r64 = new ShapedRecipe(return_enchant(64)).shape("!!!", "!#!", "!!!")
                .setIngredient('!', Material.LAPIS_LAZULI).setIngredient('#', Material.BOOK);
        ShapedRecipe anvil_r8 = new ShapedRecipe(return_anvil(8)).shape("!@!", "@#@", "!@!")
                .setIngredient('!', Material.COPPER_INGOT).setIngredient('@', Material.GOLD_INGOT)
                .setIngredient('#', Material.PAPER);
        getServer().addRecipe(enchant_r64);
        getServer().addRecipe(anvil_r8);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

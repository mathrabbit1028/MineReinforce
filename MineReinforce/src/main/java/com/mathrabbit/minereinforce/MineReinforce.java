package com.mathrabbit.minereinforce;

import org.bukkit.plugin.java.JavaPlugin;

public final class MineReinforce extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("magic").setExecutor(new GiveCommand());

        getServer().getPluginManager().registerEvents(new AnvilEvent(), this);
        getServer().getPluginManager().registerEvents(new EnchantEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

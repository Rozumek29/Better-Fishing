package com.github.rozumek29.betterfishing;

import com.github.rozumek29.betterfishing.config.ConfigurationManager;
import com.github.rozumek29.betterfishing.fish.FishManager;
import com.github.rozumek29.betterfishing.utils.ColorUtil;
import com.github.rozumek29.betterfishing.utils.Sender;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterFishing extends JavaPlugin {

    private static Economy econ = null;

    @Override
    public void onEnable() {
        sendTitle();
        ConfigurationManager.getInstance().setupConfiguration();
        if (!setupEconomy() ) {
            Sender.getInstance().sendConsoleInfo("no-vault");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        FishManager.getInstance().setupFishes();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void sendTitle(){
        getServer().getConsoleSender().sendMessage(ColorUtil.color(""));
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a  ___ ___ _____ _____ ___ ___   ___ ___ ___ _  _ ___ _  _  ___ "));
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a | _ ) __|_   _|_   _| __| _ \\ | __|_ _/ __| || |_ _| \\| |/ __|"));
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a | _ \\ _|  | |   | | | _||   / | _| | |\\__ \\ __ || || .` | (_ |"));
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a |___/___| |_|   |_| |___|_|_\\ |_| |___|___/_||_|___|_|\\_|\\___|"));
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a                                   By Rozumek29 | version: " + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(ColorUtil.color(""));
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

}

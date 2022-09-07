package com.github.rozumek29.betterfishing;

import com.github.rozumek29.betterfishing.config.ConfigurationManager;
import com.github.rozumek29.betterfishing.fish.FishManager;
import com.github.rozumek29.betterfishing.utils.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterFishing extends JavaPlugin {

    @Override
    public void onEnable() {
        sendTitle();
        ConfigurationManager.getInstance().setupConfiguration();
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
        getServer().getConsoleSender().sendMessage(ColorUtil.color("&a                                                  By Rozumek29"));
        getServer().getConsoleSender().sendMessage(ColorUtil.color(""));
    }

}

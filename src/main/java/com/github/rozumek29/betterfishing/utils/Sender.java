package com.github.rozumek29.betterfishing.utils;

import com.github.rozumek29.betterfishing.BetterFishing;
import com.github.rozumek29.betterfishing.config.ConfigurationManager;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Sender {
    private static Sender instance;
    private final ConsoleCommandSender console;
    private final String PREFIX;
    private final FileConfiguration languageConfig;
    private Sender(){
        this.PREFIX = ConfigurationManager.getInstance().getMainConfig().getString("prefix");
        this.languageConfig = ConfigurationManager.getInstance().getLanguageConfig();
        this.console = BetterFishing.getPlugin(BetterFishing.class).getServer().getConsoleSender();
    }

    public static Sender getInstance(){
        if(instance == null){
            instance = new Sender();
        }
        return instance;
    }

    public void sendConsoleInfo(String key){
        this.console.sendMessage(ColorUtil.color(this.PREFIX + this.languageConfig.getString(key)));
    }

    public void sendConsoleInfo(String key, String... args){
        String message = this.languageConfig.getString(key);
        for (int i = 0; i < args.length; i++) {
            message = message.replace("{" + i + "}", args[i]);
        }
        this.console.sendMessage(ColorUtil.color(this.PREFIX + message));
    }
}

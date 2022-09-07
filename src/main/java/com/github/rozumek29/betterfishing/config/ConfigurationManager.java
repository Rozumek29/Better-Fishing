package com.github.rozumek29.betterfishing.config;

import com.github.rozumek29.betterfishing.BetterFishing;
import com.github.rozumek29.betterfishing.utils.Sender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigurationManager {
    private File file;
    private FileConfiguration languageConfig;

    private final Plugin plugin = BetterFishing.getPlugin(BetterFishing.class);
    private static ConfigurationManager instance;
    private ConfigurationManager(){}
    public static ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void setupConfiguration(){
        // Setup for main config
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        // Setup for messages config
        setupMessages();
    }

    private void setupMessages(){
        switch (this.plugin.getConfig().getString("language")){
            case "pl" -> {
                file = new File(plugin.getDataFolder(), "languages/messages-pl.yml");
            }
            default -> {
                file = new File(plugin.getDataFolder(), "languages/messages-en.yml");
            }
        }

        if(!file.exists()){
            plugin.saveResource("languages/" + file.getName(), true);
        }
        this.languageConfig = YamlConfiguration.loadConfiguration(file);
        Sender.getInstance().sendConsoleInfo("lang-info");
    }

    public FileConfiguration getMainConfig(){
        return plugin.getConfig();
    }

    public FileConfiguration getLanguageConfig(){
        return this.languageConfig;
    }

}

package com.github.rozumek29.betterfishing.fish;

import com.github.rozumek29.betterfishing.cache.FishMap;
import com.github.rozumek29.betterfishing.config.ConfigurationManager;
import com.github.rozumek29.betterfishing.utils.Sender;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Set;

public class FishManager {
    private static FishManager instance;
    private final FileConfiguration mainConfig;
    private final Sender sender;
    private final HashMap<String, Fish> fishMap;
    private FishManager(){
        this.mainConfig = ConfigurationManager.getInstance().getMainConfig();
        this.sender = Sender.getInstance();
        this.fishMap = FishMap.getFishMap();
    }
    public static FishManager getInstance(){
        if(instance == null){
            instance = new FishManager();
        }
        return instance;
    }

    public void setupFishes(){
        this.sender.sendConsoleInfo("loading-fishes");
        ConfigurationSection section = this.mainConfig.getConfigurationSection("fishes");
        Set<String> keys = section.getKeys(false);

        for (String key : keys){
            String name = this.mainConfig.getString("fishes." + key + ".name");
            FishRarity rarity = FishRarity.valueOf(this.mainConfig.getString("fishes." + key + ".rarity"));
            Material type = Material.getMaterial(this.mainConfig.getString("fishes." + key + ".type"));
            double chance = this.mainConfig.getDouble("fishes." + key + ".chance");
            int minWeight = this.mainConfig.getInt("fishes." + key + ".minWeight");
            int maxWeight = this.mainConfig.getInt("fishes." + key + ".maxWeight");
            double pricePerGram = this.mainConfig.getDouble("fishes." + key + ".pricePerGram");
            int minExp = this.mainConfig.getInt("fishes." + key + ".minExp");
            int maxExp = this.mainConfig.getInt("fishes." + key + ".maxExp");
            fishMap.put(name, new Fish(name, rarity, type, chance, pricePerGram, minWeight, maxWeight, minExp, maxExp));
        }
        this.sender.sendConsoleInfo("loaded-fishes", String.valueOf(fishMap.size()));
    }

}

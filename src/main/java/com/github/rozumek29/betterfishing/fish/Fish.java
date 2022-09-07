package com.github.rozumek29.betterfishing.fish;

import lombok.*;
import org.bukkit.Material;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fish {
    String name;
    FishRarity rarity;
    Material type;
    double chance, pricePerGram;
    int minWeight, maxWeight, minExp, maxExp;
}

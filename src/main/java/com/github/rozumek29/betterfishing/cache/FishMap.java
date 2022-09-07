package com.github.rozumek29.betterfishing.cache;

import com.github.rozumek29.betterfishing.fish.Fish;

import java.util.HashMap;

public class FishMap {
    private static final HashMap<String, Fish> fishMap = new HashMap<>();

    public static HashMap<String, Fish> getFishMap() {
        return fishMap;
    }
}

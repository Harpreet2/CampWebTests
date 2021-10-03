package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public class NameMatch implements Strategy{

    private final String name;

    public NameMatch(String name) {
        this.name = name;
    }

    @Override
    public boolean match(PlanetTile planet) {
        return planet.getName().equalsIgnoreCase(name);
    }
}

package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;

public class RadiusMatch implements Strategy{

    private double radius;

    public RadiusMatch(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean match(PlanetTile planet) {
         return planet.getRadius() == radius;
    }
}

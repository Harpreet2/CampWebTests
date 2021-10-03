package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class PlanetTile {
    private final WebElement tile;

    public PlanetTile(WebElement planetTileElement) {
        this.tile = planetTileElement;
    }

    public String getName() {
        return tile.findElement(By.className("name")).getText();
    }

    public double getRadius() {
        String radius =  tile.findElement(By.className("radius")).getText();
        radius =  radius.split(" ")[0].replaceAll(",", "");
        return parseDouble(radius);

    }

//    public long getPlanetRadius() {
//        var radius =  tile.findElement(By.className("radius")).getText();
//        radius =  radius.split(" ")[0].replaceAll(",", "");
//        return parseLong(radius);
//    }

    public long getDistance() {
        var distance = tile.findElement(By.className("distance")).getText();
        distance = distance.split(" ")[0].replaceAll(",", "");
        return parseLong(distance);

    }

}





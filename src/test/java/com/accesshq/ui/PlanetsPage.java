package com.accesshq.ui;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PlanetsPage {
    private final WebDriver driver;

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public PlanetTile getPlanet(Predicate<PlanetTile> predicate) {
        for (WebElement planet : driver.findElements(By.className("planet"))) {
            PlanetTile planetTile = new PlanetTile(planet);
            if (predicate.test(planetTile)) {
                return planetTile;
            }
        }
        throw new NotFoundException("Planet not found.");
    }

    public long getFarthestDistance() {

        List<Long> distances = new ArrayList();

        for (WebElement planet : driver.findElements(By.className("planet"))) {
            PlanetTile planetTile = new PlanetTile(planet);
            distances.add(planetTile.getDistance());
        }
        return Collections.max(distances);
    }

}

package com.accesshq.webtests;

import com.accesshq.ui.PlanetTile;
import com.accesshq.ui.PlanetsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.Predicate;


public class PlanetTestSuite {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/planets");
        driver.manage().window().maximize();
    }

    @Test
    public void jupitersDistanceFromSunTest() {

        //Arrange
        PlanetsPage planetsPage = new PlanetsPage(driver);

        //Act
        var planet = planetsPage.getPlanet(planetTile ->
                planetTile.getName().equalsIgnoreCase("Jupiter"));

        //Assert
        Assertions.assertEquals(778500000, planet.getDistance());

    }

    @Test
    public void matchPlanetRadiusTest() {

        //Arrange
        PlanetsPage planetsPage = new PlanetsPage(driver);

        //Act
        var planet = planetsPage.getPlanet(new Predicate<PlanetTile>() {
            @Override
            public boolean test(PlanetTile planetTile) {
                return planetTile.getRadius() == 69911;
            }
        });

        Assertions.assertEquals("Jupiter", planet.getName());

    }

    @Test
    public void farthestPlanetTest() {

        //Arrange
        PlanetsPage planetsPage = new PlanetsPage(driver);

        //Act
        var planet = planetsPage.getPlanet(planetTile ->
                planetTile.getName().equalsIgnoreCase("Neptune"));

        //Assert
        Assertions.assertEquals(planetsPage.getFarthestDistance(), planet.getDistance());

    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}

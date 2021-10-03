package com.accesshq.strategies;

import com.accesshq.ui.PlanetTile;
import org.openqa.selenium.WebElement;

public interface Strategy {

    public boolean match(PlanetTile planet) ;

}

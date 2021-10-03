package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFormsButton() {
        var formButton = driver.findElement(By.cssSelector("a[aria-label='forms']"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(formButton));
        formButton.click();
    }
    public void clickPlanetButton() {
        var planetButton = driver.findElement(By.cssSelector("a[aria-label='planets']"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(planetButton));
        planetButton.click();
    }

    public WebElement ClickHomeButton() {

        for (WebElement currentButton : driver.findElements(By.tagName("button"))) {
            if (currentButton.getText().equals("home")) {
                return currentButton;
            }
        }
        throw new NotFoundException("Could not find home button.");

    }

}

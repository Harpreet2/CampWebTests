package com.accesshq.webtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTestSuite {
    WebDriver driver;

    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");

    }

    @Test
    public void DemoTest() {

        var actual = driver.findElement(By.cssSelector("h1,display-1")).getText();

        Assertions.assertEquals("Web Playground", actual);

    }

    @Test
    public void TestQuantityTest() {

        var tableElement = driver.findElement(By.tagName("table"));

        List<WebElement> inputElements = tableElement.findElements(By.tagName("input"));

        Assertions.assertEquals(1, Integer.parseInt(inputElements.get(0).getAttribute("value")));

    }

    @Test
    public void TestCLickMeButtonTest() throws InterruptedException {

        //Arrange
//        List<WebElement> formELements = driver.findElements(By.className("form"));
//        var upDownButton = formELements.get(1).findElement(By.tagName("a"));
        var upDownButton = driver.findElement(By.cssSelector("a[role='button']"));

        //Act
        upDownButton.click();

        //Assert
        String expected = "CLICK ME UP!";
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(upDownButton, expected));
        Assertions.assertEquals(expected, upDownButton.getText());

        //Act
        upDownButton.click();

        //Assert
        String nextExpected = "CLICK ME DOWN!";
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(upDownButton, nextExpected));
        Assertions.assertEquals(nextExpected, upDownButton.getText());

    }

    @Test
    public void TestHomeButtonTest() {

        var homeButton = getButton();

        homeButton.click();
        var alert = driver.findElement(By.className("alert-message"));

        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(alert, "You clicked the home button"));

        Assertions.assertEquals("You clicked the home button", alert.getText());

    }

    @Test
    public void TestFormTest() {
        
    }

    private WebElement getButton() {
        for (WebElement currentButton : driver.findElements(By.tagName("button"))) {
            if (currentButton.getText().equals("home")) {
                return currentButton;
            }
        }
        throw new NotFoundException("Could not find home button.");
    }

//    private WebElement getAlert() {
//        for (WebElement currentAlert : driver.findElements(By.className("alert-message"))) {
//            if (currentAlert.getText().equals("You clicked the home button")) {
//                return currentAlert;
//            }
//        }
//        throw new NotFoundException("Could not find Alert Box.");
//    }


    @AfterEach
    public void CleanUp() {
        driver.quit();
    }
}

package com.accesshq.webtests;

import com.accesshq.ui.FormsPage;
import com.accesshq.ui.HomePage;
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
        driver.manage().window().maximize();

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
    public void TestCLickMeButtonTest() {

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

        clickHomeButton();

        var alert = driver.findElement(By.className("alert-message"));

        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(alert, "You clicked the home button"));

        Assertions.assertEquals("You clicked the home button", alert.getText());

    }

    @Test
    public void errorMessageTest() {

        //Arrange
        new HomePage(driver).clickFormsButton();
        FormsPage forms = new FormsPage(driver);

        //Act
        forms.clickSubmit();

        //Assert
        Assertions.assertEquals(true, forms.isNameErrDisplayed());
        Assertions.assertEquals(true, forms.isEmailErrDisplayed());
        Assertions.assertEquals(true, forms.isAgreeErrDisplayed());

    }

    @Test
    public void submitFormTest() {

        //Arrange
        new HomePage(driver).clickFormsButton();
        FormsPage forms = new FormsPage(driver);

        //Act
        forms.setName("Harpreet");
        forms.setEmail("Test@test.com");
        forms.setState("VIC");
        forms.clickAgree();
        forms.clickSubmit();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(forms.getPopUpMessageBox()));

        //Assert
        Assertions.assertEquals(true, forms.isPopUpDisplayed());

    }
    public void clickHomeButton() {

        var home = driver.findElement(By.cssSelector("button[aria-label='home']"));
        home.click();

    }


    @AfterEach
    public void CleanUp() {
        driver.quit();
    }

}

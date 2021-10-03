package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {

    private WebDriver driver;

    public FormsPage(WebDriver driver) {
        this.driver =driver;
    }

    public void clickSubmit() {
        for(WebElement currentButton : driver.findElements(By.tagName("button"))) {
            //var children = currentButton.findElement(By.tagName("span"));
            if (currentButton.getText().equalsIgnoreCase("submit")) {
                currentButton.click();
                break;
            }
        }
    }


    public boolean isNameErrDisplayed() {
        return selectElementByCss("div[id='name-err']").isDisplayed();
    }

    public boolean isEmailErrDisplayed() {
        return selectElementByCss("div[id='email-err']").isDisplayed();
    }

    public boolean isAgreeErrDisplayed() {
        return selectElementByCss("div[id='agree-err']").isDisplayed();
    }

    private WebElement selectElementByCss(String cssElement) {

        var el = driver.findElement(By.cssSelector(cssElement));
        return el;

    }

    public void setName(String name) {
        selectElementByCss("input[name='name']").sendKeys(name);
    }

    public void setEmail(String email) {
        selectElementByCss("input[name='email']").sendKeys(email);
    }

    public void setState(String state) {
        selectElementByCss("input[id='state']").sendKeys(state);
    }

    public void clickAgree() {
        selectElementByCss("label[for='agree']").click();
    }

    public WebElement getPopUpMessageBox() {
        return selectElementByCss("div[role='status']");
    }

    public boolean isPopUpDisplayed() {
        return getPopUpMessageBox().isDisplayed();
    }
}

package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id ="user-name")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id ="password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id ="login-button")
    WebElement loginButton;

    public void enterUsername(String username){
        Reporter.log("Enter username" + username+ "to email field" + username.toString());
        sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS,"Enter username" + username);
    }

    public void enterPassword(String password){
        Reporter.log("Enter password" + password+ "to password field" + password.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS,"Enter password" + password);
    }

    public void clickOnLoginButton(){
        Reporter.log("Clicking login button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Clicking Login Button" );

    }

}

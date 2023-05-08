package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage= new LoginPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” username
        loginPage.enterUsername("standard_user");

        //* Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");

        //* Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();

        //* Verify the text “PRODUCTS”
        Assert.assertEquals(productPage.verifyTitleOfProductsPage(),"Products");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” username
        loginPage.enterUsername("standard_user");

        //* Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");

        //* Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();

        //* Verify that six products are displayed on page
        Assert.assertEquals(productPage.verifyNumberOfOfProductsDisplayed(),6);
    }

}

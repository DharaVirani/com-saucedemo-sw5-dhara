package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsTitle;

    @CacheLookup
    @FindBy(className = "inventory_item")
    List<WebElement> allProductList;

    public String verifyTitleOfProductsPage(){
        CustomListeners.test.log(Status.PASS,"Get Products Text" );
        Reporter.log("Get Products Text" +  productsTitle.toString());
        return getTextFromElement(productsTitle);
    }

    public int verifyNumberOfOfProductsDisplayed(){
        CustomListeners.test.log(Status.PASS,"Get Number of products" );
        Reporter.log("Get Number of Products" +  allProductList.toString());
        return getSizeOfElement(allProductList);
    }


}

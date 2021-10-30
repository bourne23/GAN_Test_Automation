package com.moneygaming.pages;

import com.moneygaming.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(DriverManager.get(), this);
    }

    @FindBy(css = "a.newUser.green")
    public WebElement joinNow;

}

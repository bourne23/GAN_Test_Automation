package com.moneygaming.pages;

import com.moneygaming.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {


    public SignUpPage() {
        PageFactory.initElements(DriverManager.get(), this);
    }

    @FindBy(id = "form")
    public WebElement joinNowButton;

    @FindBy(id = "title")
    public WebElement title;

    @FindBy(id = "forename")
    public WebElement firstName;

    @FindBy(name = "map(lastName)")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='checkbox' and @class='required checkbox terms']")
    public WebElement checkboxTermsCond;

    @FindBy(xpath = "//label[@for='dob']")
    public WebElement dobError;
}

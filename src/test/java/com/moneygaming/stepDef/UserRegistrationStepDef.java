package com.moneygaming.stepDef;

import com.moneygaming.pages.HomePage;
import com.moneygaming.pages.SignUpPage;
import com.moneygaming.utilities.ConfigReader;
import com.moneygaming.utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserRegistrationStepDef {

    WebDriver driver = DriverManager.get();
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        try {
            driver.get(ConfigReader.getProperty("url"));
            logger.info("Loading url");
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        } catch (WebDriverException we) {
            Assert.fail("WebDriverException occurred: " + we);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e);
        }
    }

    @When("the user clicks {string} button")
    public void the_user_clicks_button(String button) {

        switch (button) {
            case "JOIN NOW! on the home page":

                HomePage homePage = new HomePage();
                try {
                    WebDriverWait wait = new WebDriverWait(DriverManager.get(), 30);
                    wait.until(ExpectedConditions.elementToBeClickable(homePage.joinNow));
                } catch (TimeoutException e) {
                    Assert.fail("TimeoutException occurred: " + e);
                }
                try {
                    homePage.joinNow.click();
                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                } catch (WebDriverException we) {
                    Assert.fail("WebDriverException occurred: " + we);
                }
                break;
            case "JOIN NOW! on the sign up page":
                try {
                    new SignUpPage().joinNowButton.click();
                } catch (WebDriverException we) {
                    Assert.fail("WebDriverException occurred: " + we);
                }
                break;
            default:
                Assert.fail("Button not found");
        }

    }

    @When("the user selects {string} title from the dropdown menu")
    public void the_user_selects_title_from_the_dropdown_menu(String title) {
        HomePage homePage = new HomePage();
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.get(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(homePage.joinNow));
        } catch (TimeoutException e) {
            Assert.fail("TimeoutException occurred: " + e);
        }

        switch (title) {
            case "Miss":
                try {
                    Select titleDropdown = new Select(new SignUpPage().title);
                    titleDropdown.selectByValue("Miss");
                } catch (WebDriverException e) {
                    Assert.fail("WebDriverException occurred: " + e);
                }
                break;
            default:
                Assert.fail("Title <" + title + "> not found");
        }
    }

    @When("the user enters first name and surname")
    public void the_user_enters_first_name_and_surname(Map<String, String> name) {
        try {
            new SignUpPage().firstName.sendKeys(name.get("firstname"));
            new SignUpPage().lastName.sendKeys(name.get("surname"));
        } catch (WebDriverException e) {
            Assert.fail("WebDriverException occurred: " + e);
        }
    }

    @When("the user checks the tickbox with text {string}")
    public void theUserChecksTheTickboxWithText(String text) {

        if (text.equals("I accept the Terms and Conditions and certify that I am over the age of 18.")) {
            new SignUpPage().checkboxTermsCond.click();
        } else {
            logger.info("Error: verify checkbox text: " + text);
            Assert.fail("Error: verify checkbox text: " + text);
        }
    }


    @Then("the user validates that a validation message with text {string} appears under the date of birth box")
    public void the_user_validates_that_a_validation_message_with_text_appears_under_the_date_of_birth_box(String error) {
        try {
            Assert.assertEquals(error, new SignUpPage().dobError.getText());
        } catch (WebDriverException e) {
            Assert.fail("WebDriverException occurred: " + e);
        }
    }


    @Then("the user validates that they are on the Sign up page")
    public void theUserValidatesThatTheyAreOnTheSignUpPage() {

        Assert.assertEquals(ConfigReader.getProperty("urlSignUp"), driver.getCurrentUrl());
        Assert.assertEquals("Join now to Play Online Casino Games - Free or Cash | MoneyGaming.com", driver.getTitle());

    }
}

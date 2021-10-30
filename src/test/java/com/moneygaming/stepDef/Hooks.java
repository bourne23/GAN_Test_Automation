package com.moneygaming.stepDef;

import com.moneygaming.utilities.DriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.get().manage().window().maximize();
//        DriverManager.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        DriverManager.closeDriver();
    }

}

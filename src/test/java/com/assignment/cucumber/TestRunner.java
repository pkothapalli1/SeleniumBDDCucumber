package com.assignment.cucumber;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.assignment.utilities.BasePage;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		plugin = {"json:target/cucumber-reports/Cucumber.json" ,"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome=true
 )
public class TestRunner {
    @BeforeClass
    public static void setup() throws IOException {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/report.html");
        BasePage.launchBrowser();
    }

    @AfterClass
    public static void teardown() {
    	BasePage.closeBrowser();
        Reporter.loadXMLConfig(new File("extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("Sample Test Automation");
    }

}
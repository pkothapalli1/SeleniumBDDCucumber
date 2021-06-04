package com.assignment.utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	public static WebDriver driver;

	public static void launchBrowser() throws IOException {
		PropertiesFileReader obj = new PropertiesFileReader();
		Properties properties = obj.getProperty();
		String browserName = properties.getProperty("browser.name");
		System.out.println(browserName);
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void loadBaseURL() throws IOException {
		PropertiesFileReader obj = new PropertiesFileReader();
		Properties properties = obj.getProperty();
		driver.get(properties.getProperty("browser.baseurl"));
	}

	public static void closeBrowser() {
		driver.quit();
	}
}

package com.assignment.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ActionUtitlities extends BasePage {
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void wait(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

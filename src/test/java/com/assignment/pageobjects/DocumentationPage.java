package com.assignment.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocumentationPage {
	WebDriver driver;

	public DocumentationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "search-by")
	public WebElement SearchTextBox;

	@FindAll(value = { @FindBy(how = How.XPATH, using = "//div[@class='autocomplete-suggestion']") })
	public List<WebElement> SearchResults;

}

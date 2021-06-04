package com.assignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='About']/ancestor::div")
	public WebElement Section_About;
	@FindBy(how = How.LINK_TEXT, using = "Downloads")
	public WebElement DownloadsLink;
	@FindBy(how = How.LINK_TEXT, using = "Documentation")
	public WebElement DocumentationLink;
	@FindBy(how = How.LINK_TEXT, using = "Projects")
	public WebElement ProjectsLink;
	@FindBy(how = How.LINK_TEXT, using = "Support")
	public WebElement SupportLink;

	public void selectHeaderLink(String linktext) {
		driver.findElement(By.linkText(linktext)).click();
	}

	public void selectHeaderInAboutSection(String option) {
		Section_About.click();
		driver.findElement(By.linkText(option)).click();
	}
}

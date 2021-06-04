package com.assignment.cucumber.steps;

import com.assignment.pageobjects.DocumentationPage;
import com.assignment.pageobjects.HomePage;
import com.assignment.pageobjects.ProjectPage;
import com.assignment.utilities.ActionUtitlities;
import com.assignment.utilities.BasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Steps extends BasePage {
	HomePage homePage = new HomePage(driver);
	ProjectPage projectPage = new ProjectPage(driver);
	DocumentationPage documentationPage = new DocumentationPage(driver);
	ActionUtitlities actionUtilities = new ActionUtitlities();

	@Given("^I launch the selenium website$")
	public void i_launch_the_selenium_website() throws Throwable {
		loadBaseURL();
	}

	@When("^I navigate to \"([^\"]*)\" Page$")
	public void i_navigate_to_page(String linktext) throws Throwable {
		homePage.selectHeaderLink(linktext);
	}

	@Then("^verify the page is navigated to \"([^\"]*)\" page$")
	public void verify_the_page_is_navigated_to_page(String page) throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains(page));
	}

	@When("^I click on About section in the top header and select \"([^\"]*)\"$")
	public void i_click_on_About_section_in_the_top_header_and_select(String option) {
		homePage.selectHeaderInAboutSection(option);
	}

	@When("^I scroll and click on Learn More Button$")
	public void i_scroll_and_click_on_Learn_More_Button() {
		actionUtilities.scrollIntoView(projectPage.LearnMoreButton);
		projectPage.LearnMoreButton.click();
	}

	@When("^I search for \"([^\"]*)\" in searchbox$")
	public void i_search_for_in_searchbox(String searchText) {
		documentationPage.SearchTextBox.sendKeys(searchText);
	}

	@Then("^I select option \"([^\"]*)\" in the search result$")
	public void i_select_option_in_the_search_result(String searchOption) {
		WebElement option = documentationPage.SearchResults.get(Integer.parseInt(searchOption) - 1);
		String optionURI = option.getAttribute("data-uri");
		option.click();
		Assert.assertEquals("Search Navigation is not working", optionURI, driver.getCurrentUrl());
	}
}

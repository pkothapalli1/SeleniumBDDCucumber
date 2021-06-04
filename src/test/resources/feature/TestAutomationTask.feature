Feature: Test Automation Task

  Background: 
    Given I launch the selenium website

  Scenario: Verify Downloads page is loading
    When I navigate to "Downloads" Page
    Then verify the page is navigated to "/downloads" page

  Scenario: Verify User is navigated to Sponsors Page
    When I click on About section in the top header and select "Governance"
    Then verify the page is navigated to "/project" page
    When I scroll and click on Learn More Button
    Then verify the page is navigated to "/sponsors" page

  Scenario: Verify Documentation page is loading verify search functionality
    When I navigate to "Documentation" Page
    Then verify the page is navigated to "/documentation/en" page
    When I search for "Grid" in searchbox
    Then I select option "2" in the search result

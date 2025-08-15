@login
Feature: Home Page Module Verification
  
  This feature verifies the modules present on the home page and validates scenarios such as URL verification, home page content, and logout functionality.

  Scenario: Verify homepage modules and perform validations
    Given the user logs in with valid username and password
    When the user is successfully logged in and verify text "Welcome Support , Schoolcues"
    And the user verify the current URL contains "hotfix"
    And the user select the school name as "Olympus Heritage School - Stage" from the drop down "text"
     
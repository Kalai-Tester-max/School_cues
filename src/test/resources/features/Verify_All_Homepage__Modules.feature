@homepage
Feature: This feature is to get the list of modules present in the home page and validate
Scenario: This test is to verify the modules in the home page

Given verify the user is on home page  
When the user is logged in succesfully and take screenshot 
And the user is able to verify list of modules in homepage
And the user is validate the list of modules using Assert  
Then the user click on logout button logged out succesfully and login page 
 
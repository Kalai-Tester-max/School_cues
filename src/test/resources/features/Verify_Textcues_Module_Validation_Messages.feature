
@Textcues
Feature: verification of textcues module fields & textcues creation
 
  	Scenario: verify the mandatory fields & thier default text
 		Given I am on Teacher view & verify the text "Teachers/Staff View"
    And I click on textcues module
    Then I click on create new textcue button of textcues module 
    Then I will redirect to textcues creation page & verify the label "TextCues"
    And I will check the user handle, sender name, sender email address fields default datas "@support,s" ,"Support , Schoolcues" , "support@schoolcues.com"
 	
    Scenario: verify the message field validation message
    And I click on send message button
    Then I will able to see the validation popup of message field & verify the message "Enter message content"
    
    Scenario: verify the contact list field validation message and save the text message
    Given I have entered the data "Smoke test message" on message field
    And I click on send message button
    Then I will able to see the validation popup of contact list field & verify the message "Select one or more contact list"
    
    Scenario: verify the save text message functionality
    Then I will select the class from contact list
    And I click on send message button
    Then I click ok on the alert pop up
    
    Scenario: verification of send text message functionality
    Given I will click on the send link of text message which contains "Smoke"
    Then I click ok on the alert pop up
    
    
    @edit
    Scenario: verification of Edit text message functionality
    Given I click on edit option of text message which contains "Edit-"
    Then I edit the existing text on message box field
    Then I am choosing individual contact "Pragya Test" from the drop down "text"
    Then Verfiy the selected contact on selected contact list "vanan, kalai"
    And I click on send message button
    Then I click ok on the alert pop up
    
    @delete
    Scenario: verification of delete text message functionality
    Given I click on delete link of text message which contains "Delete-"
    Then I click ok on the alert pop up
    And I click ok on the another confirmation alert pop up
    
   
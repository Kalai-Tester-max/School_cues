package com.step_definition;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.page_objects.TextcuesPage;
import com.utilities.Common_Utils;
import com.webdriver_manager.Driver_Manager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_Textcues_Module_Validation_Messages_Stepdefinition {
	
	
	@Given("I am on Teacher view & verify the text {string}")
	public void i_am_on_teacher_view_verify_the_text(String Expected){
		try {
			String Actual = TextcuesPage.getInstance().getTeachersviewtext().getText();

			if (Actual != null && Actual.contains(Expected)) {
				System.out.println("✅User is sucessfully reached Teachersview & text located- "+Actual); 
			} else {
				System.out.println("❌Home page text verification failed. Actual: " + Actual);
			}
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}	
		}
	@Given("I click on textcues module")
	public void i_click_on_textcues_module() {
		try {
			TextcuesPage.getInstance().getTextcuesiocn().click();
			System.out.println("✅User is sucessfully clicked on textxues module ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}	
	}
	@Then("I click on create new textcue button of textcues module")
	public void i_click_on_create_new_textcue_button_of_textcues_module() {
		try {
			TextcuesPage.getInstance().Createbtn().click();
			System.out.println("✅User is sucessfully clicked create a textcue button ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Then("I will redirect to textcues creation page & verify the label {string}")
	public void i_will_redirect_to_textcues_creation_page_verify_the_label(String Expected) {
		try {
			String Actual =TextcuesPage.getInstance().Textcueslabel().getText();
			if (Actual != null && Actual.contains(Expected)) {
				System.out.println("✅User is sucessfully redirected to textcues creation page & label is located- "+Actual); 
			} else {
				System.out.println("❌ textcues creation page label verification failed. Actual: " + Actual);
			}
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}	
	}
	@Then("I click on send message button")
	public void i_click_on_send_message_button() {
		try {
			TextcuesPage.getInstance().Sendmessagebtn().click();
			System.out.println("✅User is sucessfully clicked send message button ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

@Then("I will able to see the validation popup of message field & verify the message {string}")
public void i_will_able_to_see_the_validation_popup_of_message_field_verify_the_message(String Expected) {
		try {
			Common_Utils.getInstance().waitForVisibility(TextcuesPage.getInstance().Messageboxvalidation(), 3);
			String Actual =TextcuesPage.getInstance().Messageboxvalidation().getText();
			if (Actual != null && Actual.contains(Expected)) {
				System.out.println("✅validation message of message box appeared & the message is- "+Actual );
			} else {
				System.out.println("❌ Message box validation message verification failed. Actual: " + Actual);
			}	
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Given("I have entered the data {string} on message field")
	public void i_have_entered_the_data_on_message_field(String Text) {
		try {
			TextcuesPage.getInstance().Messagefield().sendKeys(Text);
			System.out.println("✅User is sucessfully entered text on message box ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Then("I will able to see the validation popup of contact list field & verify the message {string}")
	public void i_will_able_to_see_the_validation_popup_of_contact_list_field_verify_the_message(String Expected) {
		try {
		String Actual =	TextcuesPage.getInstance().Contactlistvalidation().getText();
		if (Actual != null && Actual.contains(Expected)) {
			System.out.println("✅validation message of contact list appeared & the message is- "+Actual );
		} else {
			System.out.println("❌ contact list validation message verification failed. Actual: " + Actual);
		}
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Then("I will select the class from contact list")
	public void i_will_select_the_class_from_contact_list() {
		try {
			TextcuesPage.getInstance().QA_Olympus().click();
			System.out.println("✅User is sucessfully selected the contact list ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Then("I click ok on the alert pop up")
	public void user_clicked_ok_on_the_alert_pop_up() {
		try {
			Common_Utils.getInstance().waitForAlert(2);
			Common_Utils.getInstance().isAlertPresent();
			Common_Utils.getInstance().acceptAlert();
			System.out.println("✅User is sucessfully handled the alert ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}

	}
	
	@Then("I will check the user handle, sender name, sender email address fields default datas {string} ,{string} , {string}")
	public void i_will_check_the_user_handle_sender_name_sender_email_address_fields_default_datas
	(String Expected1, String Expected2, String Expected3) {
		try {
			String Actual1= TextcuesPage.getInstance().userhandletext().getAttribute("value");
			String Actual2= TextcuesPage.getInstance().SenderNameText().getAttribute("value");
			String Actual3= TextcuesPage.getInstance().SenderEmailAddressText().getAttribute("value");
			System.out.println("✅User is sucessfully verified the default text's userhandle- "+Actual1+
					" SenderName- "+Actual2+ " SenderEmailAddress- "+Actual3);
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	
	@Given("I will click on the send link of text message which contains {string}")
	public void i_will_click_on_the_send_link_of_text_message_which_contains(String Message) {
		try {
			TextcuesPage.getInstance().performSendByKeyword(Message);
			System.out.println("✅Send link clicked");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
//	@Then("I can see the {string} status of the text message")
//	public void i_can_see_the_status_of_the_text_message(String Expected){
//		try {
//			Common_Utils.getInstance().waitForVisibility(TextcuesPage.getInstance().ProcessingText(), 2);
//		String Actual=  TextcuesPage.getInstance().ProcessingText().getText();
//		if (Actual != null && Actual.contains(Expected)) {
//			System.out.println("✅Text message status changed to - "+Actual);
//		} else {
//			System.out.println("Text message status verfification filed Actual is-  " + Actual);
//		}
//			
//		}catch(Exception e) {
//			System.out.println(e);
//			Common_Utils.getInstance().screenShot();
//			Assert.fail(e.getMessage());
//		}
//	}
	
//	@Then("I can see the {string} status of the text message which contains {string}")
//	public void i_can_see_the_status_of_the_text_message_which_contains(String Expected, String Message) {
//	    try {
//	    	TextcuesPage.getInstance().IdentifyProcessingStatus(Message).
//	    }catch(Exception e) {
//			System.out.println(e);
//			Common_Utils.getInstance().screenShot();
//			Assert.fail(e.getMessage());
//	    }
//	}
	
	@Given("I click on edit option of text message which contains {string}")
	public void i_click_on_edit_option_of_text_message_which_contains(String Message) {
		try {
			TextcuesPage.getInstance().performEditByKeyword(Message);
			System.out.println("✅Edit link has been clicked ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("I edit the existing text on message box field")
	public void i_edit_the_existing_text_on_message_box_field(){
		try {
			TextcuesPage.getInstance().Messagefield().clear();
			TextcuesPage.getInstance().Messagefield().sendKeys("Text has been edited");
			System.out.println("✅Text message has been edited");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	@Given("I click on delete link of text message which contains {string}")
	public void i_click_on_delete_link_of_text_message_which_contains(String Message) {
		try {
			TextcuesPage.getInstance().performDeleteByKeyword(Message);
			System.out.println("✅Edit link has been clicked ");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("I am choosing individual contact {string} from the drop down {string}")
	public void i_am_choosing_single_student_from_select_individual_contact_list(String ClassName,String howto) {
		try {
			Common_Utils.getInstance().ImplicitlyWait();
			TextcuesPage.getInstance().Individualcontactlist().click();
			Common_Utils.getInstance().selectFromDropDown(TextcuesPage.getInstance().Classdropdown(), howto, ClassName);
			TextcuesPage.getInstance().Addallarrow().click();
			Thread.sleep(3000);
			System.out.println("✅Individual contacts has been selected");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("Verfiy the selected contact on selected contact list {string}")
	public void verfiy_the_selected_contact_on_selected_contact_list(String Expected) {
		try {
			String Actual = TextcuesPage.getInstance().kalai_vanan().getText();
			if (Actual != null && Actual.contains(Expected)) {
				System.out.println("✅Selected contact moved to selected conatct list which is- "+Actual );
			} else {
				System.out.println("❌Selected contact verification failed. Actual is: " + Actual);
			}
			System.out.println("✅Individual contacts has been selected");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("I click ok on the another confirmation alert pop up")
	public void i_click_ok_on_the_another_confirmation_alert_pop_up() {
		try {
			Common_Utils.getInstance().isAlertPresent();
			Common_Utils.getInstance().acceptAlert();
			Common_Utils.getInstance().screenShot();
			System.out.println("✅Text message deleted successfully");
		}catch(Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

}

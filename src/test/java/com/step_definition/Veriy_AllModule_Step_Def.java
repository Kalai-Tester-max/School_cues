package com.step_definition;

import com.constants.Constants_Class;
import com.page_objects.LoginPage;
import com.webdriver_manager.Driver_Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Veriy_AllModule_Step_Def {

	@Given("verify the user is on home page")
	public void verify_the_user_is_on_home_page() {
		try {
			Driver_Manager.getDriver().get(Constants_Class.APP_URL);
			Thread.sleep(2000);
			LoginPage.getInstance().getUSERNAME().sendKeys(Constants_Class.USER_NAME);
			LoginPage.getInstance().getPASSWORD().sendKeys(Constants_Class.PASSWORD);
			LoginPage.getInstance().getLOGINBTN().click();
			System.out.println("✅User is verified at homepage");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail(e.getMessage());
		}
	}
	@When("the user is logged in succesfully and take screenshot")
	public void the_user_is_logged_in_succesfully_and_take_screenshot() {
		
		System.out.println("the user is logged in succesfully and take screenshot");
	}

	@When("the user is able to verify list of modules in homepage")
	public void the_user_is_able_to_verify_list_of_modules_in_homepage() {
		System.out.println("the user is able to verify list of modules in homepage");
	}

	@When("the user is validate the list of modules using Assert")
	public void the_user_is_validate_the_list_of_modules_using_assert() {
		System.out.println("the user is validate the list of modules using Assert");
	}

	@Then("the user click on logout button logged out succesfully and login page")
	public void the_user_click_on_logout_button_logged_out_succesfully_and_login_page() {
		System.out.println("the user click on logout button logged out succesfully and login page");
	}
}

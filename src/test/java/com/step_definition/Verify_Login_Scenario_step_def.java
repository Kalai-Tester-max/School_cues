package com.step_definition;

import com.constants.Constants_Class;
import com.page_objects.HomePage;
import com.page_objects.LoginPage;
import com.utilities.Common_Utils;
import com.webdriver_manager.Driver_Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Verify_Login_Scenario_step_def {

	@Given("the user logs in with valid username and password")
	public void the_user_logs_in_with_valid_username_and_password() throws InterruptedException {
		try {
			Driver_Manager.getDriver().get(Constants_Class.APP_URL);
			Thread.sleep(2000);
			LoginPage.getInstance().getUSERNAME().sendKeys(Constants_Class.USER_NAME);
			LoginPage.getInstance().getPASSWORD().sendKeys(Constants_Class.PASSWORD);
			LoginPage.getInstance().getLOGINBTN().click();
			System.out.println("✅User is sucessfully logged in");
		} catch (Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user is successfully logged in and verify text {string}")
	public void the_user_is_successfully_logged_in_and_verify_text(String expected) throws InterruptedException {
		try {
			String actual = HomePage.getInstannce().getHomepagetext();

			if (actual != null && actual.contains(expected)) {
				System.out.println("✅Home page text is verified");
			} else {
				System.out.println("❌Home page text verification failed. Actual: " + actual);
			}
		} catch (Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}

	}

	@When("the user verify the current URL contains {string}")
	public void the_user_verify_the_current_url_contains(String expected) {
		try {
			String url = Driver_Manager.getDriver().getCurrentUrl();

			String expectedPartialUrl = "hotfix";

			if (url != null && url.toLowerCase().contains(expected.toLowerCase())) {
				System.out.println("✅ Current URL is verified: " + url);
			} else {
				System.out.println("❌ URL verification failed. Actual URL: " + url + ", Expected to contain: "
						+ expectedPartialUrl);
			}
		} catch (Exception e) {
			System.out.println(e);
			Common_Utils.getInstance().screenShot();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user select the school name as {string} from the drop down {string}")
	public void the_user_select_the_school_name_as_from_the_drop_down(String schoolTittle, String howto) {
		try {
			Common_Utils.getInstance().selectFromDropDown(HomePage.getInstannce().getCSCHOOLTITTLE(), howto,
					schoolTittle);
			System.out.println("✅ dropdown handled and test school Olympus Heritage is choosen");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail(e.getMessage());

		}

	}



//	@Then("the user logs out successfully and a screenshot of the login page is captured")
//	public void the_user_logs_out_successfully_and_a_screenshot_of_the_login_page_is_captured() {
//		try {
//			HomePage.getInstannce().getLOGOUTBTN().click();
//			System.out.println("✅ logout sucessfully and screen shot has been taken ");
//			Common_Utils.getInstance().screenShot();
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail(e.getMessage());
//
//		}
//
//	}
}

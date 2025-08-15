package com.step_definition;

import com.utilities.Common_Utils;
import com.webdriver_manager.Driver_Manager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definition {

	public static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {// browser initialized//property files loaded//webelements//
													// initialized

		try {

			scenarioName = scenario.getName();
			Common_Utils.getInstance().loadProperties();
			if (Driver_Manager.getDriver() == null) {
				Driver_Manager.launchBrowser();
				Driver_Manager.getDriver().manage().window().maximize();
				// Common_Utils.initWebElements();
				Common_Utils.getInstance().initWebElements();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

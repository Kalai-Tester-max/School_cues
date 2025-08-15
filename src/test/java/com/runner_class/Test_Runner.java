package com.runner_class;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 glue = "com.step_definition",
		         monochrome = false,
		         tags = "@login or @Textcues",
		         plugin = {"rerun:failed_scenario/failed_scenarios.txt"},
		         dryRun = false
		         
		        )

public class Test_Runner {

	

} 

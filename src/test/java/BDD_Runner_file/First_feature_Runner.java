package BDD_Runner_file;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/java/BDD_Features",
		glue="BDD_Step_Definitions",
		tags={"@Valid_Scenario_excel"},
		strict=true,
		
		monochrome=true,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-html-reports"}
		
		)


public class First_feature_Runner {
	

}

package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/Features/XML.feature",
		glue={"stepDefinitions"}
		)
public class FormFillerRunner extends AbstractTestNGCucumberTests {
	
}

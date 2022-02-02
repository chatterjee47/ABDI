package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;

import cleverMediaPages.FormPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testUtility.JsonDataProvider;
import testUtility.TestBase;

public class FormFillerSteps extends JsonDataProvider {

	static Properties prop;
	static FileInputStream fileInput;
	static File file = new File(System.getProperty("user.dir") + "\\Config\\config.properties");
	FormPage formpage;

	@Before
	public void Configuration() {
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Given("user is on clevermedia web form")
	public void user_is_on_clevermedia_web_form() {
		TestBase.initialization(prop.getProperty("browserName"), prop.getProperty("url"));
	}

	@When("user enters first name {int}")
	public void user_enters_first_name(int FirstName) throws InterruptedException {
		Thread.sleep(1000);
		formpage = new FormPage(TestBase.driver);
		JsonDataProvider.dataProvider();
		obj = (JSONObject) cusinfojsonarray.get(FirstName);
		firstname = (String) obj.get("firstName");
		formpage.enterFistName(firstname);
		
	}

	@When("user enters last name {int}")
	public void user_enters_last_name(int LastName) {
		obj = (JSONObject) cusinfojsonarray.get(LastName);
		lastname = (String) obj.get("lastName");
		formpage.enterLastName(lastname);
		
	}

	@When("user enters zipcode {int}")
	public void user_enters_zipcode(int ZipCode) {
		obj = (JSONObject) cusinfojsonarray.get(ZipCode);
		zipcode = (String) obj.get("zipCode");
		formpage.enterZipCode(zipcode);
		
	}

	@When("user enters message {int}")
	public void user_enters_message(int Message) {
		obj = (JSONObject) cusinfojsonarray.get(Message);
		message = (String) obj.get("Message");
		formpage.enterTextMessage(message);
	}

	@When("user clicks on submit")
	public void user_clicks_on_submit() {
		formpage.clickOnSubmitButton();
		formpage.closebrowser();
	}

	

}

package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cleverMediaPages.FormPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testUtility.TestBase;
import testUtility.XMLFileReader;

public class XMLFillStepDefs extends TestBase{
	
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
	

	@Given("User is on clevermedia web form")
	public void user_is_on_clevermedia_web_form() {
		TestBase.initialization(prop.getProperty("browserName"), prop.getProperty("url"));
	}
	
	@When("User enters first name {int} from XML data sheet") 
	public void user_enters_first_name_from_xml_data_sheet(Integer FirstName) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(1000);
		XMLFileReader.XMLRead(FirstName);
		Thread.sleep(1000);
		formpage = new FormPage(TestBase.driver);
		formpage.enterFistName(XMLFileReader.firstname);
		
	}

	@When("User enters last name {int} from XML data sheet")
	public void user_enters_last_name_from_xml_data_sheet(Integer LastName) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(1000);
		XMLFileReader.XMLRead(LastName);
		Thread.sleep(1000);
		formpage = new FormPage(TestBase.driver);
		formpage.enterLastName(XMLFileReader.lastname);
		
	}

	@When("User enters zipcode {int} from XML data sheet")
	public void user_enters_zipcode_from_xml_data_sheet(Integer ZipCode) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(1000);
		XMLFileReader.XMLRead(ZipCode);
		Thread.sleep(1000);
		formpage = new FormPage(TestBase.driver);
		formpage.enterZipCode(XMLFileReader.zipcode);
		
	}

	@When("User enters message {int} from XML data sheet")
	public void user_enters_message_from_xml_data_sheet(Integer Message) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(1000);
		XMLFileReader.XMLRead(Message);
		Thread.sleep(1000);
		formpage = new FormPage(TestBase.driver);
		formpage.enterTextMessage(XMLFileReader.message);
		
	}

	@When("User clicks on submit button after entering all data from XML data sheet")
	public void user_clicks_on_submit_button_after_entering_all_data_from_xml_data_sheet() {
		formpage.clickOnSubmitButton();
		formpage.closebrowser();
	}

}
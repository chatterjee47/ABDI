package cleverMediaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='zipcode']")
	WebElement zipCode;

	@FindBy(xpath = "//textarea[@name='bodytext']")
	WebElement messageTextBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFistName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void enterZipCode(String zipcode) {
		zipCode.sendKeys(zipcode);
	}

	public void enterTextMessage(String textMessage) {
		messageTextBox.sendKeys(textMessage);
	}

	public void clickOnSubmitButton() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", submit);
	}
	
	public void closebrowser(){
		driver.close();
	}

}

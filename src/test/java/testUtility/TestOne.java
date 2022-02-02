package testUtility;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {
	public static WebDriver driver;

	public static void main(String[] args) {

		// WebElement book = driver.findElement(By.xpath(""));

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.delta.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement depart = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calenderDepartSpan")));
			depart.click();

			List<WebElement> calMonth = driver.findElements(By.xpath("//div[@class='dl-datepicker-title']"));
			for (WebElement mo : calMonth) {
				if (!mo.getText().contains("January2022")) {
					do {
						System.out.println(mo.getText());
						WebElement next = driver.findElement(By.xpath("//a[@aria-label='Next']"));
						next.click();
					} while (!mo.getText().contains("January2022"));
					break;
				}
			}

			List<WebElement> availableDates = driver.findElements(
					By.xpath("//tbody[@class='dl-datepicker-tbody-0']//tr/td[@class='dl-datepicker-available-day']"));
			for (WebElement dateAvailable : availableDates) {
				if (dateAvailable.getText().contains("22")) {
					dateAvailable.click();
				}
			}

			WebElement done = driver.findElement(By.xpath("//button[text()='done']"));
			done.click();

			WebElement returnR = driver.findElement(By.xpath("//span[@class='calReturnLabelCont']"));
			returnR.click();

			List<WebElement> calMontht = driver.findElements(By.xpath("//div[@class='dl-datepicker-title']"));
			for (WebElement mo : calMontht) {
				if (!mo.getText().contains("February2022")) {
					do {
						System.out.println(mo.getText());
						WebElement nextt = driver.findElement(By.xpath("//a[@aria-label='Next']"));
						nextt.click();
					} while (!mo.getText().contains("February2022"));
					break;
				}
			}

			List<WebElement> availableReturnDates = driver.findElements(
					By.xpath("//tbody[@class='dl-datepicker-tbody-0']//tr/td[@class='dl-datepicker-available-day']"));
			for (WebElement availableReturnD : availableReturnDates) {
				if (availableReturnD.getText().contains("28")) {
					availableReturnD.click();
				}
			}

			done.click();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

package testUtility;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitTest {

		public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launches Browser and maximizes it 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		//clicks on account list
		//driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[contains(text(), 'Hello, Sign in')]")).click();
		
		
		
		
		
		//Hovers over Account List WebElement
		WebElement accountList = driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[contains(text(), 'Hello, Sign in')]"));
		Actions action = new Actions(driver);
		action.moveToElement(accountList).perform();
		
		
		
	
		
		
		//clicks on sign in
		driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[contains(text(), 'Sign in')]")).click();
		
		
		
		
		
		/*
		//waits till Email visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))); 
		*/
		
		//Enters user id
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abdi.teramu7@gmail.com");
		
		
		
		//continue continue button
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		

		
		
		//Enters password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("m55EjSZ%v##W");
		
		
		
		//click on sign in 
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
		
		//Verifies if the cart is visible
		WebElement cart = driver.findElement(By.xpath("//*[@id='nav-cart-count']"));
		String cartText = cart.getText();
		System.out.println(cartText);
		Assert.assertEquals((driver.findElement(By.xpath("//*[@id='nav-cart-count']"))), cart);
		

		//Hovers over and Clicks on Account List
		WebElement userAccount = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(userAccount).perform();
		
		String amazonHomePageTitle = driver.getTitle();
		System.out.println(amazonHomePageTitle);
		/*
		//clicks on sign out and close browser
		driver.findElement(By.xpath("//a[@id='nav-item-signout']//span[contains(text(), 'Sign Out')]")).click();
		driver.quit();
		driver.close();
		*/
	}

}

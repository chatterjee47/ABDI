package testUtility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Toast {

	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\Config\\config.properties");
				prop.load(fis);
					
				}catch (Exception e) {
					
				}

			System.out.println(prop.getProperty("browser"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
		
		
	
		
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				}
			 else if(browserName.equals("FF")) {
				 WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				}
			 else if(browserName.equals("edge")) {
				 WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			 }else {
					System.out.println("No Browser Value Given");
				}

				driver.get(prop.getProperty("url"));
			 }
			
				
}

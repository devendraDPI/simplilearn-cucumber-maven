package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Baseclass {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		
		driver.quit();
		
	}

}

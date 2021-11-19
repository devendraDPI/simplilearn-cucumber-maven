package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefs {
	
	WebDriver driver = Baseclass.driver;
	
	@Given("^User has navigated to the Login Page$")
    public void user_has_navigated_to_the_login_page() throws Throwable {
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
        
    }

    @When("^User enters correct Username and Password$")
    public void user_enters_correct_username_and_password() throws Throwable {
    	
    	WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("user1@xyz.com");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abz@96o1t");
        
    }

    @Then("^User Should be navigated to the Home Page$")
    public void user_should_be_navigated_to_the_home_page() throws Throwable {
        
    }
    

    @And("^User clicks on the Login Button$")
    public void user_clicks_on_the_login_button() throws Throwable {
    	
    	WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
        
    }
    
    @When("^User enters correct Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void user_enters_correct_username_something_and_password_something(String UsernameVal, String PasswordVal) throws Throwable {
    	
    	WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UsernameVal);
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);
        
    }
    
    @Then("^User Should be getting error message \"([^\"]*)\"$")
    public void user_should_be_getting_error_message_something(String ExpMsg) throws Throwable {
        
    	WebElement Error = driver.findElement(By.id("msg_box"));
		String ActualMsg = Error.getText();
		
		Assert.assertEquals(ExpMsg, ActualMsg);
    }
    
    @When("^User enters correct Crienditals$")
    public void user_enters_correct_crienditals(DataTable table) throws Throwable {
        
    	String UsernameVal = table.cell(1, 1);
    	String PasswordVal = table.cell(2, 1);
    	
    	WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UsernameVal);
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);
    	
    }

}

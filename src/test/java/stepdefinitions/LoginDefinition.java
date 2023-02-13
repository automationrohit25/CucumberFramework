package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDefinition {
	
	WebDriver driver;
	 
    @Given("User is on Home page")
    public void userOnHomePage() {
 
    System.out.println("Thread ID - " + Thread.currentThread().getId());
    WebDriverManager.firefoxdriver().setup();
 
     driver = new FirefoxDriver();
 
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
     driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @Given("User enters username as {string}")
    public void entersUsername(String userName) throws InterruptedException {
 
     System.out.println("Username Entered");
     driver.findElement(By.name("username")).sendKeys(userName);
 
    }
 
    @Given("User enters password as {string}")
    public void entersPassword(String passWord) throws InterruptedException {
 
     System.out.println("Password Entered");
     driver.findElement(By.name("password")).sendKeys(passWord);
     driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }
 
    @Given("User should be able to login sucessfully")
    public void sucessfullLogin() throws InterruptedException {
 
    String newPageText = driver.findElement(By.id("welcome")).getText();
    System.out.println("newPageText :" + newPageText);
    driver.quit();
    }
}

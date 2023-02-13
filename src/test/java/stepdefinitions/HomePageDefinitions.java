package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageDefinitions {
	
	WebDriver driver;
	 
    @Given("User Navigates to HRM login page")
    public void userOnHomePage() {
 
        System.out.println("Thread ID - " + Thread.currentThread().getId());
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @And("User login with valid credentials")
    public void entersCredentials() throws InterruptedException {
        Thread.sleep(9000);
 
        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(9000);
        System.out.println("Entered Username");
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(9000);
        System.out.println("Entered Password");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
 
    }
 
    @When("User is in Dashboard page")
    public void verifyDashboardPage() {
 
        String dashboardTitle = driver.findElement(By.xpath("//title[text()='OrangeHRM']")).getText();
        System.out.println(dashboardTitle);
        System.out.println("I have printed the title");
 
    }
 
    @Then("there are valid QuickLaunch options {string}")
    public void verifyQuickLinks(String options) throws InterruptedException {

        /*switch (options) {
        case "Assign Leave":
            String linkOne = driver
                    .findElement(By.xpath(
                            "//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/span"))
                    .getText();
            Assert.assertEquals(linkOne, options);
            Thread.sleep(1000);
            break;
        case "Leave List ":
            String linkTwo = driver
                    .findElement(By.xpath(
                            "//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[2]/div/a/span"))
                    .getText();
            Assert.assertEquals(linkTwo, options);
            Thread.sleep(1000);
            break;
        case "Timesheets":
            String linkThree = driver
                    .findElement(By.xpath(
                            "//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[3]/div/a/span"))
                    .getText();
            Assert.assertEquals(linkThree, options);
            Thread.sleep(1000);
            break;
        default:
            break;
        }
 */
    	Thread.sleep(9000);
    	driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
    	Thread.sleep(9000);
        driver.quit();
 
    }
 
    @Then("there are valid Legend options {string}")
    public void verifyMenuOptions(String options) throws InterruptedException {
        switch (options) {
        case "Not assigned to Subunits":
            String linkOne = driver
                    .findElement(
                            By.xpath("//*[@id='div_legend_pim_employee_distribution_legend']/table/tbody/tr[1]/td[2]"))
                    .getText();
            Assert.assertEquals(linkOne, options);
            Thread.sleep(1000);
            break;
        case "Administration":
            String linkTwo = driver
                    .findElement(
                            By.xpath("//*[@id='div_legend_pim_employee_distribution_legend']/table/tbody/tr[2]/td[2]"))
                    .getText();
            Assert.assertEquals(linkTwo, options);
            Thread.sleep(1000);
            break;
        case "Client Services":
            String linkThree = driver
                    .findElement(
                            By.xpath("//*[@id='div_legend_pim_employee_distribution_legend']/table/tbody/tr[3]/td[2]"))
                    .getText();
            Assert.assertEquals(linkThree, options);
            Thread.sleep(1000);
            break;
        default:
            break;
 
        }
        driver.quit();
    }

}

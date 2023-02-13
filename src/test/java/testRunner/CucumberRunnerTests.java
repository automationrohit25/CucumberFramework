package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "@ValidCredentials", features = "src/test/resources/features", glue = "stepdefinitions")
 
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
 
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
    
}

package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"Stepdefinition", "Utilities"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
        monochrome = true,
        dryRun = false
)

public class TestRunner {

}
package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import javax.swing.text.html.HTML;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/resources/features",
        glue = "cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)
public class run {
}

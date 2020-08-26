import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"steps"},
        monochrome = true,
        plugin = {"pretty", "junit:target/reports/junit-reports/report.xml",
                "json:target/reports/json-reports/report.json",
                "html:target/reports/html-reports/report.html"})
public class TestRunner {


}

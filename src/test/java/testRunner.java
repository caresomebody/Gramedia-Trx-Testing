import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        plugin = {"pretty"},
        tags = "not @skip",
        glue={"StepDefinition"}
)

public class testRunner {
}
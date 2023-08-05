package helperSelenium;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class helper {

    WebDriver driver = Serenity.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));



}

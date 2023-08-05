package StepDefinition;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.edge.EdgeDriver;

public class stepdef{

//Opening Firefox Browser and launching the login page of application

    private final WebDriver driver = new EdgeDriver();

    @Given("user navigates to the login page by opening Firefox")
    public void user_navigates_to_the_login_page_by_opening_firefox()
    {
        driver.get("https://studentportal.ipb.ac.id/Account/Login?ReturnUrl=%2F");
    }

//Entering correct username and password values

    @When("user enters correct username and password values")
    public void enter_Username_Password()
    {
        driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("ali_naufal26");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("marcha26$");
    }

//Open homepage upon login

    @Then("user gets directed to homepage")
    public void direct_to_homepage() throws Throwable
    {
        driver.get("https://studentportal.ipb.ac.id/");
    }

    @After()
    public void closeBrowser()
    {
        driver.quit();
    }
}
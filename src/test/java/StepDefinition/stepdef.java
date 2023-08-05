package StepDefinition;

import io.cucumber.java.After;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class stepdef{

//Opening Firefox Browser and launching the login page of application

    private final WebDriver driver = new EdgeDriver();

    @Given("user login to Gramedia")
    public void user_login() throws IOException {
        driver.get(mappers.mappers.openProps("URLGRAMEDIA"));
        driver.findElement(By.xpath("//button[contains(.,'Masuk')]")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mappers.mappers.openProps("EMAIL"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(mappers.mappers.openProps("PASS"));
        driver.findElement(By.xpath("//button[@class='submit']")).click();
    }

    @Given("user search book")
    public void user_search_book() throws IOException {
        driver.findElement(By.xpath("//div[@class='search-area']//div[@class='search-input-dekstop']//input[@name='search']")).sendKeys("Home Sweet Loan");
        driver.findElement(By.xpath("//div[@class='search-area']//div[@class='search-input-dekstop']//input[@name='search']")).sendKeys(Keys.ENTER);
    }

    @When("user click book")
    public void user_click_book() throws IOException {
        driver.findElement(By.xpath("//div[@class='content-wrap']")).click();
    }

    @When("user click format")
    public void user_click_format() throws IOException {
        driver.findElement(By.xpath("//div[@class='section-format']")).click();
    }

    @When("user choose format")
    public void user_choose_format() throws IOException {
        driver.findElement(By.xpath("//ul[@class='list-store']//div[@class='wrap-info']/div[.='Gramedia Depok']")).click();
    }

    @When("user click cart")
    public void user_click_cart() throws IOException {
        driver.findElement(By.xpath("//button[@class='cart-btn']")).click();
    }

    @Step
    @When("user wait {int} seconds")
    public void user_wait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }

    @Step
    @When("user will find success text")
    public void user_find_visible() throws InterruptedException {
        driver.findElement(By.xpath("//h2[.='Berhasil Dimasukkan ke Tas Belanja!']"));
    }



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
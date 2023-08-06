package StepDefinition;

import io.cucumber.java.After;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class stepdef{

//Opening Firefox Browser and launching the login page of application

    WebDriver driver = new EdgeDriver();
    WebElement webEle ;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

    @When("user click buy now")
    public void user_buy_now() throws IOException {
        driver.findElement(By.xpath("//button[@class='buy-btn']")).click();
    }

    @When("user click cart icon")
    public void user_click_cart_icon() throws IOException {
        driver.findElement(By.xpath("//div[@class='navigation-area']//div[@id='cart-area']//i[@class='icon ion-bag']")).click();
    }

    @Step
    @When("user wait {int} seconds")
    public void user_wait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }

    @Step
    @When("user will find success add to cart text")
    public void user_find_visible() throws InterruptedException {
        driver.findElement(By.xpath("//h2[.='Berhasil Dimasukkan ke Tas Belanja!']"));
    }

    @When("user will find products in cart")
    public void productsInCart() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='detail']/a[contains(.,'Home Sweet Loan')]"));
    }

    @When("user will find 'Tas Kamu Belanja Kamu Berdebu' text")
    public void cartEmpty() throws InterruptedException {
        driver.findElement(By.xpath("//p[.='Tas Belanja Kamu Berdebu!']"));
    }

    @When("user remove book")
    public void userDeleteBook() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//div[@class='navigation-area']//div[@id='cart-area']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//button[.='Lihat Keranjang']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//div[@class='wrap-total']//span[.='Hapus']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//button[@class='btn-delete']")).click();
        user_wait(15);
    }

    @When("user add product to cart")
    public void userAddToCart() throws IOException, InterruptedException {
        user_search_book();
        user_wait(15);
        user_click_book();
        user_wait(15);
        user_click_format();
        user_wait(15);
        user_choose_format();
        user_wait(15);
        user_click_cart();
        user_wait(15);
        driver.findElement(By.xpath("//i[@class='ion-close']")).click();
        user_wait(15);
    }

    @When("user lanjut ke pembayaran")
    public void userToPayment() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='navigation-area']//div[@id='cart-area']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//button[.='Lihat Keranjang']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//button[contains(.,'Lanjut ke Pembayaran')]")).click();
        user_wait(15);
    }

    @When("user choose delivery")
    public void userChooseDelivery() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(.,'Pilih Metode Pengiriman')]")).click();
        user_wait(15);
        driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='methods ng-star-inserted']/div[contains(.,'Sicepat')]")).click();
        user_wait(15);
        driver.findElement(By.xpath("//p[.='Cargo (minimal 10Kg) (Rp 35.000)']")).click();
        user_wait(15);
    }

    @When("user choose payment")
    public void userChoosePayment() throws InterruptedException {
        driver.findElement(By.xpath("//p[@class='btn-change-payment ng-star-inserted']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//p[.='Virtual Account Mandiri (Otomatis)']")).click();
        user_wait(15);
        driver.findElement(By.xpath("//button[@class='btn-order']")).click();
        user_wait(15);
    }

    @When("user checkout")
    public void userCheckOut() throws InterruptedException {
        scroll("//div[@id='checkout-right']/button[contains(.,'Bayar')]");
        user_wait(10);
        driver.findElement(By.xpath("//div[@id='checkout-right']/button[contains(.,'Bayar')]")).click();
        user_wait(30);
        driver.findElement(By.xpath("//h4[.='Sisa Waktu Pembayaran Anda']"));
    }

    @When("user check cart")
    public void userCheckCart() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[@class='navigation-area']//div[@id='cart-area']")).click();
        boolean cart = expect("//p[.='Belum ada produk dalam keranjang']");

        if(cart){
            userAddToCart();
        } else {
            userDeleteBook();
        }
        driver.get(mappers.mappers.openProps("URLGRAMEDIA"));
    }


    @After()
    public void closeBrowser()
    {
        driver.quit();
    }

    public WebElement find_element(String element, String type){
        By data = By.xpath(element);

        if (type.equals("visible")){
            webEle = wait.until(ExpectedConditions.presenceOfElementLocated (data));
        }else {
            webEle = driver.findElement(data);
        }
        return webEle;
    }

    public boolean expect(String element) {
        try {
            WebElement expEl = find_element(element,"notVisible");

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void scroll(String element) throws InterruptedException{
        WebElement scroll = find_element(element,"visible");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scroll);
        Thread.sleep(1000);
    }
}
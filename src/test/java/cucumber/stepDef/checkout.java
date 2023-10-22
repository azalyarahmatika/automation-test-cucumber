package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("User is on the cart page")
    public void cart_page(){
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Assertion
        WebElement cartPage = driver.findElement(By.xpath("//span[contains(@class, 'title') and contains(text(), 'Your Cart')]"));
        String cartPageText = cartPage.getText();
        Assert.assertEquals("Your Cart", cartPageText);
    }

    @When("User clicks the Checkout button")
    public void checkout_button(){
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("User is directed to a page to fill out the form")
    public void information_form(){
        driver.findElement(By.xpath("//span[@class='title' and text()='Checkout: Your Information']"));
    }

    @When("Input first name")
    public void input_first_name(){
        driver.findElement(By.id("first-name")).sendKeys("standard_user");
    }

    @And("Input last name")
    public void input_last_name(){
        driver.findElement(By.id("last-name")).sendKeys("user");
    }

    @And("Input postal code")
    public void input_postal_code(){
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }

    @And("User clicks the Continue button")
    public void continue_button(){
        driver.findElement(By.id("continue")).click();
    }

    @Then("User is directed to the product overview page")
    public void overview_page(){
        driver.findElement(By.xpath("//span[contains(@class, 'title') and contains(text(), 'Checkout: Overview')]"));
    }

    @When("User clicks the Finish button")
    public void finish_button(){
        driver.findElement(By.id("finish")).click();
    }

    @Then("User is directed to the successful checkout page")
    public void success_page(){
        driver.findElement(By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']"));
        driver.close();
    }
}


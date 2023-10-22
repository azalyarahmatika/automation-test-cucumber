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

public class addToCart {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("User is on homepage to add product")
    public void homePage_cart(){
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Assertion
        WebElement homepage = driver.findElement(By.xpath("//span[@class='title']"));
        String homepageText = homepage.getText();
        Assert.assertEquals("Products", homepageText);
    }

    @When("User clicks Add to Cart button")
    public void add_to_cart_button(){
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("The button changes to Remove")
    public void remove_button(){
        WebElement remove_button = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        String remove_button_text = remove_button.getText();
        Assert.assertEquals("Remove", remove_button_text);
    }

    @And("A symbol indicating the cart is not empty appears")
    public void cart_badge(){
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
    }

    @When("User clicks on the cart")
    public void cart(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("User can view the corresponding product")
    public void cart_inside(){
        WebElement inventory = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String inventoryText = inventory.getText();
        Assert.assertEquals("Sauce Labs Backpack", inventoryText);

        driver.close();
    }
}

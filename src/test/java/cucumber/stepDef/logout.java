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

public class logout {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("User is on homepage")
    public void homePage(){
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

    @When("User clicks the hamburger menu")
    public void hamburger_menu(){
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @And("User clicks Logout")
    public void logout_button(){
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("User is directed to login page")
    public void login_page(){
        WebElement loginForm = driver.findElement(By.xpath("//div[@class='login_logo']"));
        String loginFormText = loginForm.getText();
        Assert.assertEquals("Swag Labs", loginFormText);
        driver.close();
    }
}

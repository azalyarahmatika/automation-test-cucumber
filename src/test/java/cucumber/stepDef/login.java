package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/";

    @Given("Login page")
    public void loginPage(){
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Assertion
        WebElement loginForm = driver.findElement(By.xpath("//div[@class='login_logo']"));
        String loginFormText = loginForm.getText();
        Assert.assertEquals("Swag Labs", loginFormText);
    }

    @When("Input standard_username")
    public void input_standard_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("Input locked_out_user")
    public void input_locked_out_user(){
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @And("Input password")
    public void input_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void click_login_button(){
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("Directed to homepage")
    public void homepage(){
        WebElement homepage = driver.findElement(By.xpath("//span[@class='title']"));
        String homepageText = homepage.getText();
        Assert.assertEquals("Products", homepageText);
        driver.close();
    }

    @Then("Get error message")
    public void error_message(){
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessageText);
        driver.close();
    }
}

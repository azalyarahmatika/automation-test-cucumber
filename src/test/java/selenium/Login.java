package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public void login_success() {
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.click();
        username.sendKeys("standard_user");

        password.click();
        password.sendKeys("secret_sauce");

        loginButton.click();

        WebElement homepage = driver.findElement(By.xpath("//span[@class='title']"));
        String homepageText = homepage.getText();
        Assert.assertEquals("Products", homepageText);

        driver.close();
    }

    @Test
    public void login_failed() {
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.click();
        username.sendKeys("locked_out_user");

        password.click();
        password.sendKeys("secret_sauce");

        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessageText);

        driver.close();
    }
}

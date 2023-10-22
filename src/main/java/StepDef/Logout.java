package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.Assert;

public class Logout {
    WebDriver driver;

    @Given("User logged in")
    public void userLoggedIn()  {
        // Initialize the WebDriver and navigate to the website
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // Perform the login (You would need to provide valid login credentials)
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

    }

    @And("User navigate to left sidebar")
    public void userNavigateToLeftSidebar()  {
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }

    @When("User click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @Then("User back to saucedemo website login page")
    public void userBackToSaucedemoWebsiteLoginPage() {
        Assert.assertEquals("Swag Labs",driver.findElement(By.className("login_logo")).getText());
        System.out.println("Scenario : Logout from saucedemo website");
        System.out.println("You successfully log out from saucedemo website");
        driver.quit();
    }
}
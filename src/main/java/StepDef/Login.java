package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class Login {
    WebDriver driver;
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir "+dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("Clicks the login button")
    public void clicksTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for a moment to allow the login attempt to process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        WebElement productLabel = driver.findElement(By.className("title"));
        String labelText = productLabel.getText();
        Assert.assertEquals(labelText,"Products");
        driver.quit();
    }

    @When("User enters invalid username and or password")
    public void userEntersInvalidUsernameAndOrPassword() {
        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter invalid login credentials
        usernameField.sendKeys("invalid_username");
        passwordField.sendKeys("invalid_password");
    }

    @Then("User receives an error message")
    public void userReceivesAnErrorMessage() {
        // Check if an error message is displayed (indicating a failed login)
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-button"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Login failed as expected. Error message: " + errorMessage.getText());
        } else {
            System.out.println("Login was successful, which is unexpected.");
        }

        // Close the browser
        driver.quit();
    }

}

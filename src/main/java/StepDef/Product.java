package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class Product {
    WebDriver driver;
    String labelText;


    @Given("User at products page")
    public void userAtProductsPage() {
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

    @When("User click a product title")
    public void userClickAProductTitle() {
        WebElement titleProduct = driver.findElement(By.id("item_4_title_link"));
        labelText = titleProduct.getText();
        titleProduct.click();
    }

    @Then("User can see that product description page")
    public void userCanSeeThatProductDescriptionPage() {
        WebElement productLabel = driver.findElement(By.className("inventory_details_name"));
        String titleText = productLabel.getText();
        Assert.assertEquals(titleText,labelText);
        driver.quit();
    }

}

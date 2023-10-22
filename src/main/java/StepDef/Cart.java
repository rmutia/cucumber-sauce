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

public class Cart {

    WebDriver driver;

    @Given("User browse products")
    public void userBrowseProducts() {
        // Initialize the WebDriver and navigate to the website
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir "+dir);
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
    @When("User adds a product to the cart")
    public void userAddsAProductToTheCart() {
        WebElement cartButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        //WebElement productItem = driver.findElement(By.id("item_2_title_link"));
        cartButton.click();
    }



    @Then("Remove button displayed")
    public void removeButtonDisplayed() {
        // Check if remove button displayed
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-onesie"));
        if (removeButton.isDisplayed()) {
            System.out.println("Remove button displayed");
            String removeText = removeButton.getText();
            Assert.assertEquals(removeText,"Remove");
        } else {
            System.out.println("Remove button not displayed");
        }
    }

    @And("Plus one cart item")
    public void plusOneCartItem() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        if (cartBadge.isDisplayed()) {
            System.out.println("Add to cart was successful.");
            WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
            cartLink.click();

            WebElement productLabel = driver.findElement(By.className("inventory_item_name"));
            String labelText = productLabel.getText();
            Assert.assertEquals(labelText,"Sauce Labs Onesie");
            //driver.quit();
        } else {
            System.out.println("Add to cart failed");
        }

    }
}

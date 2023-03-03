package steps_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ExcelUtil;
import java.io.IOException;
import java.time.Duration;


public class Login {

    public static WebDriver driver;

    @Before
    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().minimize();

        ExcelUtil.file_setup();
        }

    @When("user enters correct username and correct password")
    public void user_enters_correct_user_name_and_correct_password() throws IOException {
            // read from excel
            String username = ExcelUtil.getCellData(ExcelUtil.file_setup(), "Sheet1", 1, 0);
            String password = ExcelUtil.getCellData(ExcelUtil.file_setup(), "Sheet1", 1, 1);
            //pass data to the application
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        }
    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();// click login
        System.out.println("click log in");
    }
    @Then("user should be navigated to the inventory page")
    public void user_should_be_navigated_to_the_inventory_page() {
        //public static void assertTrue(,)
        String tittle = "Swag Labs";
        String actual_tittle = driver.getTitle();
        Assert.assertEquals(tittle, actual_tittle);
        System.out.println(actual_tittle);
        driver.quit();
    }
    @When("user enters incorrect username and incorrect password")
    public void user_enters_incorrect_username_and_incorrect_password() throws IOException {
        // read from excel
        String username = ExcelUtil.getCellData(ExcelUtil.file_setup(), "Sheet1", 2, 0);
        String password = ExcelUtil.getCellData(ExcelUtil.file_setup(), "Sheet1", 2, 1);
        System.out.println("User-name" + username);
        System.out.println("Password" + password);

        //pass data to the application
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }

    // Call the click method created before
    public void click_enter(){
        clicks_on_the_login_button();
    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        //verify if element is displayed
        boolean error_message  = driver.findElement(By.className("error-button")).isDisplayed();
        Assert.assertTrue(error_message);
        driver.quit();

    }


}


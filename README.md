# QAAssignmentDivyeshDARJI
Company Name:- Mahindra Finance | Position :- QA Engineer | QA-Assignment-DivyeshDARJI


The given sample is Selenium WebDriver script in Java that covers the mentioned test cases for the login page and password recovery feature of a mobile application. This script uses the TestNG framework for test case organization and assertions.

**Assumptions:**
1. The mobile application is a web-based application accessible through a browser.
2. The web elements (username field, password field, login button, forgot password link, etc.) are identified using their HTML attributes such as IDs, names, or classes.
3. Please replace the placeholder values in the script with the actual locators and other details specific to your application.

**Basic code of project :**
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MobileAppLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (assuming ChromeDriver is used)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the login page
        driver.get("your_application_login_url");
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        // Test Case 1: Verify successful login with valid credentials
        // Your implementation here
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        // Test Case 2: Validate error message for invalid login
        // Your implementation here
    }

    @Test(priority = 3)
    public void testRetainFieldsAfterFailedLogin() {
        // Test Case 3: Ensure fields retain values after a failed login attempt
        // Your implementation here
    }

    @Test(priority = 4)
    public void testLoginButtonState() {
        // Test Case 4: Test login button state with empty fields
        // Your implementation here
    }

    @Test(priority = 5)
    public void testEnabledLoginButton() {
        // Test Case 5: Confirm login button is enabled with valid input
        // Your implementation here
    }

    @Test(priority = 6)
    public void testForgotPasswordLink() {
        // Test Case 6: Verify redirection to password recovery page
        // Your implementation here
    }

    @Test(priority = 7)
    public void testPasswordRecovery() {
        // Test Case 7: Validate password recovery functionality
        // Your implementation here
    }

    @Test(priority = 8)
    public void testPagination() {
        // Test Case 8: Test pagination on the login page
        // Your implementation here
    }

    @Test(priority = 9)
    public void testPasswordStrength() {
        // Test Case 9: Check password strength and validation messages
        // Your implementation here
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

This script provides a basic structure for your test automation. You need to fill in the details for each test case based on your application's specific implementation, such as the actual locators, URLs, and other relevant details. Additionally, you may need to add explicit waits, handle pop-ups, and implement other necessary features depending on your application's behavior.

Thanks & Best Regards
Divyesh DARJI




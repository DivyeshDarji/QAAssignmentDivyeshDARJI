package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class MobileAppLoginTest extends BaseClass {

	LoginPage loginPage;

	// By encapsulating the login functionality in a separate method, you promote
	// code reusability and maintainability. If there are changes to the login
	// process in the future, you only need to update the method in one place.
	public void loginToApplication(WebDriver driver, String username, String password) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.LoginClick("your_username", "your_password");
		// loginPage.LoginWithoutClick("your_username", "your_password");
	}

	// Test Case 1: Verify successful login with valid credentials
	@Test(priority = 1)
	public void testSuccessfulLogin() {
		try {

			// Calling Login method to perform basic functionality check using
			// "valid_userName" & "valid_password"
			loginToApplication(driver, "valid_userName", "valid_password");

			// Verify successful login by checking if a welcome message or dashboard element
			// is present
			WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));

			// Assuming 'welcomeMessage' is an element that is displayed after successful
			// login
			// Adjust the locator and condition based on your application

			// Assertion
			String expectedWelcomeMessage = "Welcome, User!";
			String actualWelcomeMessage = welcomeMessage.getText();
			Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Login was not successful.");

		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testSuccessfulLogin: " + e.getMessage());
		}
	}

	// Test Case 2: Validate error message for invalid login
	@Test(priority = 2)
	public void testInvalidLogin() {
		try {

			// Calling Login method to perform basic functionality check using
			// "invalid_username" & "invalid_password"
			loginToApplication(driver, "invalid_username", "invalid_password");

			// Verify that an error message is displayed
			WebElement errorMessage = driver.findElement(By.id("errorMessage"));

			// Assuming 'errorMessage' is an element that is displayed for invalid login
			// attempts
			// Adjust the locator and condition based on your application

			// Assertion
			Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid login.");
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testInvalidLogin: " + e.getMessage());
		}
	}

	// Test Case 3: Ensure fields retain values after a failed login attempt
	@Test(priority = 3)
	public void testRetainFieldsAfterFailedLogin() {
		try {

			// Calling Login method to perform basic functionality check using
			// "valid_userName" & "valid_password"
			loginToApplication(driver, "valid_userName", "valid_password");

			// Attempt a failed login (you might need to adjust this based on your
			// application's behavior)
			// For example, provide invalid credentials that would result in a failed login

			// Verify that the entered values are retained
			// Assertion
			Assert.assertEquals(loginPage.getUsername(), "valid_username", "Username field value not retained.");
			Assert.assertEquals(loginPage.getPassword(), "valid_password", "Password field value not retained.");
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testRetainFieldsAfterFailedLogin: " + e.getMessage());
		}
	}

	// Test Case 4: Test login button state with empty fields
	@Test(priority = 4)
	public void testLoginButtonState() {
		try {
			// Verify that the 'Login' button is initially disabled
			Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button is not disabled with empty fields.");

			// Enter values in both fields
			loginPage.LoginWithoutClick("valid_username", "valid_password");

			// Verify that the 'Login' button is enabled after entering valid values
			Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button is not enabled with valid input.");
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testLoginButtonState: " + e.getMessage());
		}
	}

	// Test Case 5: Confirm login button is enabled with valid input
	@Test(priority = 5)
	public void testEnabledLoginButton() {
		try {

			// Verify that the 'Login' button is initially disabled
			Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button is not disabled initially.");

			// Enter valid values in both fields
			loginPage.LoginWithoutClick("valid_username", "valid_password");

			// Verify that the 'Login' button is enabled after entering valid values
			Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button is not enabled with valid input.");

			// Clear the fields
			loginPage.clearUserNameField();
			loginPage.clearPasswordField();

			// Verify that the 'Login' button is disabled after clearing the fields
			Assert.assertFalse(loginPage.isLoginButtonEnabled(),
					"Login button is not disabled after clearing the fields.");
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testEnabledLoginButton: " + e.getMessage());
		}
	}

	// Test Case 6: Verify redirection to password recovery page
	@Test(priority = 6)
	public void testForgotPasswordLink() {
		try {
			// Locate the 'Forgot Password' link
			WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
			// Adjust the locator based on how the link is identified in your application

			// Click the 'Forgot Password' link
			forgotPasswordLink.click();

			// Verify that the user is redirected to the password recovery page
			String recoveryPageTitle = driver.getTitle();
			// Assuming the title of the recovery page is "Password Recovery"
			// Adjust the condition based on your application

			// Assertion
			Assert.assertEquals(recoveryPageTitle, "Password Recovery",
					"User not redirected to the password recovery page.");
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testForgotPasswordLink: " + e.getMessage());
		}
	}

	// Test Case 7: Validate password recovery functionality
	@Test(priority = 7)
	public void testPasswordRecovery() {
		try {
			// a. Click the 'Forgot Password' link
			WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
			forgotPasswordLink.click();

			// b. Enter a registered email address in the provided field
			WebElement emailField = driver.findElement(By.id("email")); // Adjust the locator
			emailField.sendKeys("registered_email@example.com");

			// c. Click the 'Recover Password' button
			WebElement recoverButton = driver.findElement(By.id("recoverButton")); // Adjust the locator
			recoverButton.click();

			// d. Verify that a success message is displayed
			WebElement successMessage = driver.findElement(By.id("successMessage")); // Adjust the locator
			Assert.assertTrue(successMessage.isDisplayed(), "Success message not displayed.");

			// e. Simulate the password recovery process by accessing the provided email or
			// using a test email account
			// f. Retrieve the recovery instructions and follow the specified steps to reset
			// the password

			// g. Ensure that after successfully resetting the password, the user is
			// redirected to the login page
			// (Assuming successful password reset redirects to the login page)
			String loginPageTitle = PasswordResetHelper.resetPasswordAndReturnToLoginPage(driver,
					"registered_email@example.com"); // Implement this method
			Assert.assertEquals(loginPageTitle, "Login Page",
					"User not redirected to the login page after password reset.");

			// h. Validate that the user can log in with the new password
			PasswordResetHelper.loginWithNewPassword(driver, "username", "password"); // Implement this method

			// Additional assertions or steps can be added based on your application's
			// behavior

		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testPasswordRecovery: " + e.getMessage());
		}
	}

	// Test Case 8: Test pagination on the login page
	@Test(priority = 8)
	public void testPagination() {
		try {
			// Assuming there is a table with data and pagination controls
			WebElement table = driver.findElement(By.id("data-table")); // Adjust the locator
			WebElement nextButton = driver.findElement(By.id("next-button")); // Adjust the locator

			// Iterate through pages and capture data
			do {
				// Capture relevant data from the current page
				PasswordResetHelper.captureDataFromCurrentPage(table);

				// Check if there is a next page
				if (PasswordResetHelper.isNextPageAvailable(nextButton)) {
					// Click the 'Next' button to navigate to the next page
					nextButton.click();
				} else {
					// Break the loop if there is no next page
					break;
				}
			} while (true);

		}

		catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testPagination: " + e.getMessage());
		}
	}

	// Test Case 9: Check password strength and validation messages
	@Test(priority = 9)
	public void testPasswordStrength() {
		try {
			// Locate the password input field
			WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator

			// Enter different passwords to test strength
			PasswordResetHelper.testPassword(driver, "weakpassword", "Weak Password: The password is too short.");
			PasswordResetHelper.testPassword(driver, "Medium123",
					"Medium Password: The password should include a mix of letters, numbers, and symbols.");
			PasswordResetHelper.testPassword(driver, "Strong@P@ssw0rd", "Strong Password: Great job!");

			// Additional test cases can be added based on your password strength criteria
		} catch (Exception e) {
			// Handle any exception that may occur during the test
			e.printStackTrace();
			Assert.fail("Exception during testPasswordStrength: " + e.getMessage());
		}
	}

}

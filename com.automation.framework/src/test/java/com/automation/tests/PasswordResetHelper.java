package com.automation.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PasswordResetHelper {

	private WebDriver driver;

	public static String resetPasswordAndReturnToLoginPage(WebDriver driver, String email) {
		// Assuming there is a link or button to initiate the password reset process on
		// the password recovery page
		initiatePasswordReset(driver, email);

		// Simulate the password reset process
		// Retrieve recovery instructions, set a new password, etc.

		// Navigate back to the login page
		navigateToLoginPage(driver);

		// Return the title of the login page for verification purposes
		return driver.getTitle();
	}

	private static void initiatePasswordReset(WebDriver driver, String email) {
		// Locate and interact with elements to initiate the password reset process
		WebElement emailField = driver.findElement(By.id("email")); // Adjust the locator
		WebElement resetButton = driver.findElement(By.id("resetButton")); // Adjust the locator

		// Enter the registered email address
		emailField.sendKeys(email);

		// Click the 'Reset' or 'Recover' button
		resetButton.click();
	}

	private static void navigateToLoginPage(WebDriver driver) {
		// Assuming there is a link or button to navigate back to the login page after
		// password reset
		WebElement loginLink = driver.findElement(By.linkText("Back to Login")); // Adjust the locator
		loginLink.click();
	}

	public static void loginWithNewPassword(WebDriver driver, String username, String newPassword) {
		// Assuming there are username, password, and login button elements on the login
		// page
		WebElement usernameField = driver.findElement(By.id("username")); // Adjust the locator
		WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator
		WebElement loginButton = driver.findElement(By.id("loginButton")); // Adjust the locator

		// Fill in the username and new password
		usernameField.sendKeys(username);
		passwordField.sendKeys(newPassword);

		// Click the login button
		loginButton.click();
	}

	// Implement logic to capture and process data from the current page
	// For example, extract table rows and process the data
	// You may need to adjust this based on your application's HTML structure
	public static void captureDataFromCurrentPage(WebElement table) {
		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Iterate through each row and process the data
		for (WebElement row : rows) {
			// Assuming the data is present in columns (td elements)
			List<WebElement> columns = row.findElements(By.tagName("td"));

			// Extract and process data from each column
			String column1Data = columns.get(0).getText(); // Adjust index based on your application
			String column2Data = columns.get(1).getText();
			// ... Extract other columns as needed

			// Process the data, for example, print to console or perform assertions
			System.out.println("Data from Column 1: " + column1Data);
			System.out.println("Data from Column 2: " + column2Data);
			// ... Process other columns as needed
		}
	}

	// Implement logic to check if the 'Next' button is available
	// Return true if the 'Next' button is present, otherwise false
	public static boolean isNextPageAvailable(WebElement nextButton) {
		return nextButton.isDisplayed() && nextButton.isEnabled();
	}
	
	public static void testPassword(WebDriver driver, String password, String expectedValidationMessage) {
        // Enter the password
        WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator
        passwordField.clear();
        passwordField.sendKeys(password);

        // Optionally, wait for the validation message to be displayed
        // (You may need to adjust this based on your application's behavior)

        // Locate the validation message element
        WebElement validationMessage = driver.findElement(By.id("validationMessage")); // Adjust the locator

        // Verify the validation message matches the expected message
        Assert.assertEquals(validationMessage.getText(), expectedValidationMessage,
                "Validation message mismatch for password: " + password);
    }

}

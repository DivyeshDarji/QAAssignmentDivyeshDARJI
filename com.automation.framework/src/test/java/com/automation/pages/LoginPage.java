package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		this.driver = ldriver;
	}

	// WebElements Inititalization
	WebElement usernameField = driver.findElement(By.id("username"));
	public WebElement passwordField = driver.findElement(By.id("password"));
	WebElement loginButton = driver.findElement(By.id("loginButton"));

	public void LoginWithoutClick(String userName, String password) {
		usernameField.sendKeys("userName");
		passwordField.sendKeys("password");

	}

	public void LoginClick(String userName, String password) {
		LoginWithoutClick(userName, password);

		// Click the login button
		loginButton.click();
	}

	// Verify that the entered values are retained
	public String getUsername() {
		String enteredUsername = usernameField.getAttribute("value");
		return enteredUsername;
	}

	// Verify that the entered values are retained
	public String getPassword() {
		String enteredPassword = passwordField.getAttribute("value");
		return enteredPassword;
	}

	// check login button is enabled or not
	public boolean isLoginButtonEnabled() {
		// Verify that the 'Login' button is initially disabled
		boolean isLoginButtonEnabled = loginButton.isEnabled();
		return isLoginButtonEnabled;
	}

	// Clear the fields values
	public void clearUserNameField() {
		usernameField.clear();
	}

	// Clear the fields values
	public void clearPasswordField() {
		passwordField.clear();
	}

}

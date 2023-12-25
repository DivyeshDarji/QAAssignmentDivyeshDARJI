package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		try {

			// get the project path
			String path = System.getProperty("user.dir");
			System.out.println("Path : " + path);

			// set driver property
			System.setProperty("webdriver.chrome.driver", path + "\\driver\\chrome\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Navigate to the login page
			driver.get("https://www.google.com");
		} catch (Exception e) {

			// Handle any exception that may occur during setup
			e.printStackTrace();
			Assert.fail("Exception during setup: " + e.getMessage());
		}

	}

	@AfterClass
	public void tearDown() {
		try {
			// Close the browser
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			// Handle any exception that may occur during teardown
			e.printStackTrace();
			Assert.fail("Exception during teardown: " + e.getMessage());
		}
	}
}

package com.webdriver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.constants.Constants_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Manager {

	private static WebDriver driver = null;

	public static void launchBrowser() {

		try {
			String browser = Constants_Class.BROWSER != null ? Constants_Class.BROWSER.toLowerCase() : "chrome";
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to launch browser", e);
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}

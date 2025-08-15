package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants_Class;
import com.page_objects.HomePage;
import com.page_objects.LoginPage;
import com.page_objects.TextcuesPage;
import com.step_definition.Common_Step_Definition;
import com.webdriver_manager.Driver_Manager;

public class Common_Utils {

	private static Common_Utils Common_UtilsInstance = null;
	private static Workbook book;
	private static FileInputStream fi;

	private Common_Utils() {
	}

	public static Common_Utils getInstance() {

		if (Common_UtilsInstance == null) {
			Common_UtilsInstance = new Common_Utils();
		}
		return Common_UtilsInstance;

	}

//config file loader
	public void loadProperties() {
		Properties properties = new Properties();
		// load property file
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (input == null) {
				throw new RuntimeException(" config.properties file not found in classpath!");
			}

			properties.load(input);

			// Assign values to constants
			Constants_Class.APP_URL = properties.getProperty("APP_URL");
			Constants_Class.BROWSER = properties.getProperty("Browser");
			Constants_Class.USER_NAME = properties.getProperty("User_Name");
			Constants_Class.PASSWORD = properties.getProperty("Password");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" Failed to load config.properties", e);
		}
	}

	
	//Initiate WebELements
	public void initWebElements() {
		PageFactory.initElements(Driver_Manager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(Driver_Manager.getDriver(), HomePage.getInstannce());
		PageFactory.initElements(Driver_Manager.getDriver(), TextcuesPage.getInstance());

	}

	//Take screenshot
	public void screenShot() {

		File screenshot = ((TakesScreenshot) Driver_Manager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Definition.getScenarioName() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	//Highlight Web element
	public void highLightElemnts(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) Driver_Manager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", element);

	}
	
	//Drop down handling
	public void selectFromDropDown(WebElement dropdown, String howto, String value) {

		Select select = new Select(dropdown);

		switch (howto) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println(
					"Please provide a valid selection in the feature file, Valid selections are: text, value, index.");
			break;
		}

	}
	
	// Check if alert is present
    public boolean isAlertPresent() {
        try {
        	Driver_Manager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
 
    // Accept alert
    public void acceptAlert() {
        if (isAlertPresent()) {
            Alert alert = Driver_Manager.getDriver().switchTo().alert();
            alert.accept();
            System.out.println("✅ Alert accepted.");
        } else {
            System.out.println("⚠️ No alert present to accept.");
        }
    }
 
    // Dismiss alert
    public void dismissAlert() {
        if (isAlertPresent()) {
            Alert alert = Driver_Manager.getDriver().switchTo().alert();
            alert.dismiss();
            System.out.println("✅ Alert dismissed.");
        } else {
            System.out.println("⚠️ No alert present to dismiss.");
        }
    }
 
    // Get alert text
    public String getAlertText() {
        if (isAlertPresent()) {
            return Driver_Manager.getDriver().switchTo().alert().getText();
        } else {
            System.out.println("⚠️ No alert present to get text.");
            return null;
        }
    }
 
    // Send keys to prompt alert
    public void sendKeysToAlert(String text) {
        if (isAlertPresent()) {
            Driver_Manager.getDriver().switchTo().alert().sendKeys(text);
            System.out.println("✅ Sent input to alert.");
        } else {
            System.out.println("⚠️ No alert present to send keys.");
        }
    }
    
  // Implicit wait
    public void ImplicitlyWait() {
    	Driver_Manager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
 // 🔹 Wait for element to be visible
 	public void waitForVisibility(WebElement element, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.visibilityOf(element));
 	}
  
 // 🔹 Wait for element to be clickable
 	public void waitForClickable(WebElement element, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.elementToBeClickable(element));
 	}
  
 // 🔹 Wait for element to be invisible
 	public void waitForInvisibility(WebElement element, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.invisibilityOf(element));
 	}
  
 // 🔹 Wait for element to contain specific text
 	public void waitForText(WebElement element, String expectedText, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
 	}
  
 // 🔹 Wait for alert to be present
 	public Alert waitForAlert(int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		return wait.until(ExpectedConditions.alertIsPresent());
 	}
  
 // 🔹 Wait for title to contain keyword
 	public void waitForTitleContains(String title, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.titleContains(title));
 	}
  
 // 🔹 Wait for URL to contain keyword
 	public void waitForUrlContains(String partialUrl, int timeoutSec) {
 		WebDriverWait wait = new WebDriverWait(Driver_Manager.getDriver(), Duration.ofSeconds(timeoutSec));
 		wait.until(ExpectedConditions.urlContains(partialUrl));
 	}

    //Excel file reading
	public static String Datafromsheet(String sheetname, int rownum, int cellnum) {

		File f = new File("C:\\Users\\SathyaMoorthy\\eclipse-workspace\\prototype_cucumber_automation\\datadriven");

		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
		}

		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {
		}

		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();// 0 or 1

		String value = null;

		if (cellType == CellType.STRING) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
			value = s.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;}
	
	
	
	public void get_text(String DFF) {
	
	}
	
}

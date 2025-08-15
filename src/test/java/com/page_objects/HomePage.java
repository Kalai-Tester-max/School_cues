package com.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.Common_Utils;

public class HomePage {

	public static HomePage HomePageInstance;

	public HomePage() {

	}

	public static HomePage getInstannce() {
		if (HomePageInstance == null) {
			HomePageInstance = new HomePage();
		}
		return HomePageInstance;

	}

	@FindBy(xpath = "//a[@id='ctl00_aSchoolSetting']//li")
	private WebElement adminview;

	@FindBy(xpath = "//a[@id='ctl00_aUserBHome']//li")
	private WebElement parentview;

	@FindBy(xpath = "//a[@id='ctl00_aBusinessHome']//li")
	private WebElement teacherstaffview;

	@FindBy(xpath = "//span[@id='ctl00_HeaderUC1_lblLoginUserName']")
	private WebElement HOMEPAGETEXT;

	@FindBy(xpath = "//select[@id='ctl00_HeaderUC1_ProvNamesDropDownList']")
	private WebElement SCHOOLTITTLE;

	@FindBy(xpath = "//a[@id='ctl00_HeaderUC1_LoginView2_LoginStatus1']")
	private WebElement LOGOUTBTN;

//	public WebElement getHomepagetext() {
//		return homepagetext;
//	}

	public WebElement getLOGOUTBTN() {
		return LOGOUTBTN;
	}

	public WebElement getCSCHOOLTITTLE() {
		Common_Utils.getInstance().highLightElemnts(SCHOOLTITTLE);
		return SCHOOLTITTLE;
	}

	public String getHomepagetext() {
		Common_Utils.getInstance().highLightElemnts(HOMEPAGETEXT);
		return HOMEPAGETEXT.getText();

	}

	public WebElement getParentview() {
		return parentview;
	}

	public WebElement getTeacherstaffview() {
		return teacherstaffview;
	}

	public WebElement getAdminview() {
		return adminview;
	}

}

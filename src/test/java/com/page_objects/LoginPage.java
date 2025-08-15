package com.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.Common_Utils;

public class LoginPage {

	public static LoginPage LoginInstance;

	private LoginPage() {

	}

	public static LoginPage getInstance() {
		if (LoginInstance == null) {
			LoginInstance = new LoginPage();
		}
		return LoginInstance;

	}

	@FindBy(xpath = "//input[@id='LoginView2_LoginUser_UserName']")
	private WebElement USERNAME;

	@FindBy(xpath = "//input[@id='LoginView2_LoginUser_Password']")
	private WebElement PASSWORD;

	@FindBy(css = "#LoginView2_LoginUser_LoginButton")
	private WebElement loginbtn;

//	@FindBy(css = "#LoginView2_LoginUser_LoginButton")
//	private WebElement loginbtn;

	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	private WebElement forgetpass;

	@FindBy(xpath = "//label[normalize-space()='Remember Me']")
	private WebElement remembercheckbox;

	@FindBy(xpath = "//i[@title='Click here to show/hide password']")
	private WebElement passvisiblebtn;

	@FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
	private WebElement privacylink;

	@FindBy(xpath = "//a[normalize-space()='Terms of Use']")
	private WebElement termslink;

	@FindBy(xpath = "//a[normalize-space()='Terms of Use']")
	private WebElement contactlink;

	@FindBy(xpath = "//span[@class='launcher-text elements__LauncherText-sc-4gy1pz-1 hmSVpf']")
	private WebElement helpbtn;

//	public void enterUserName(String username) {
//		USERNAME.sendKeys(username);
//  }

	public WebElement getUSERNAME() {
		Common_Utils.getInstance().highLightElemnts(USERNAME);
		return USERNAME;
	}

	public WebElement getPASSWORD() {
		Common_Utils.getInstance().highLightElemnts(PASSWORD);
		return PASSWORD;
	}

	public WebElement getLOGINBTN() {
		Common_Utils.getInstance().highLightElemnts(loginbtn);
		return loginbtn;
	}

	public WebElement getForgetpass() {
		return forgetpass;
	}

	public WebElement getRemembercheckbox() {
		return remembercheckbox;
	}

	public WebElement getPassvisiblebtn() {
		return passvisiblebtn;
	}

	public WebElement getPrivacylink() {
		return privacylink;
	}

	public WebElement getTermslink() {
		return termslink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getHelpbtn() {
		return helpbtn;
	}

}

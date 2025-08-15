package com.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.Common_Utils;
import com.webdriver_manager.Driver_Manager;

public class TextcuesPage {
	
	public static TextcuesPage TextcuesPageInstance;
	
	
	private TextcuesPage(){
		
	}
	
	public static TextcuesPage getInstance() {
		if(TextcuesPageInstance == null ) {
			TextcuesPageInstance = new TextcuesPage();
		}
		return TextcuesPageInstance;
	}
	
	
	@FindBy(xpath = "//strong[normalize-space()='Teachers/Staff View']")
	private WebElement Teachersviewtext;
	
	@FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_dlModuleList_ctl26_lnkModuleName']")
	private WebElement Textcuesiocn;
	
	@FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_btnAddNew']")
	private WebElement Createbtn;
	
	@FindBy(xpath = "//td[@class='help_school_new_1']")
	private WebElement Textcueslabel;
	
	@FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_btnSave']")
	private WebElement Sendmessagebtn;
	
	@FindBy(xpath = "//li[normalize-space()='Enter message content.']")
	private WebElement Messageboxvalidation;
	

	@FindBy(xpath = "//textarea[@id='ctl00_ContentPlaceHolder1_txtContent']")
	private WebElement Messagefield;
	
	
	@FindBy(xpath = "//div[@id='divCustomMessage']")
	private WebElement Contactlistvalidation;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_clUserControl_RepeaterConList_ctl70_rptCB']")
	private WebElement QA_Olympus;
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtTxtID']")
	private WebElement userhandletext;
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtSenderName']")
	private WebElement SenderNameText;
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtSenderEmailAdd']")
	private WebElement SenderEmailAddressText;
	
	
	@FindBy(xpath = "//*[text()=\"Select Individual Contacts\"]")
	private WebElement Individualcontactlist;
	
	@FindBy(xpath = "//label[normalize-space()='Select Class List']")
	private WebElement Selectclasslistlabel;
	
	@FindBy(xpath = "//select[@id='ctl00_ContentPlaceHolder1_ddlContactListName']")
	private WebElement Classdropdown;
	
	@FindBy(xpath = "//option[@value='66124c4b-d370-4fbd-b165-d6e2e4cb6d22']")
	private WebElement Parentname;
	
	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnAllAvailable\"]")
	private WebElement Addallarrow;
	
	@FindBy(xpath = "//option[@value='66124c4b-d370-4fbd-b165-d6e2e4cb6d22']")
	private WebElement kalai_vanan;
	
	
	public WebElement getTeachersviewtext() {
		Common_Utils.getInstance().highLightElemnts(Teachersviewtext);
		return Teachersviewtext;
	}

	
	public WebElement getTextcuesiocn() {
		Common_Utils.getInstance().highLightElemnts(Textcuesiocn);
		return Textcuesiocn;
	}
	
	public WebElement Createbtn() {
		Common_Utils.getInstance().highLightElemnts(Createbtn);
		return Createbtn;
	}
	
	public WebElement Textcueslabel() {
		Common_Utils.getInstance().highLightElemnts(Textcueslabel);
		return Textcueslabel;
	}
	
	public WebElement Sendmessagebtn() {
		Common_Utils.getInstance().highLightElemnts(Sendmessagebtn);
		return Sendmessagebtn;
	}
	
	public WebElement Messageboxvalidation() {
		Common_Utils.getInstance().highLightElemnts(Messageboxvalidation);
		return Messageboxvalidation;
	}
	public WebElement Messagefield() {
		Common_Utils.getInstance().highLightElemnts(Messagefield);
		return Messagefield;
	}
	
	public WebElement Contactlistvalidation() {
		Common_Utils.getInstance().highLightElemnts(Contactlistvalidation);
		return Contactlistvalidation;
	}
	
	public WebElement QA_Olympus() {
		Common_Utils.getInstance().highLightElemnts(QA_Olympus);
		return QA_Olympus;
	}
	
	public WebElement userhandletext() {
		Common_Utils.getInstance().highLightElemnts(userhandletext);
		return userhandletext;
	}
	
	public WebElement SenderNameText() {
		Common_Utils.getInstance().highLightElemnts(SenderNameText);
		return SenderNameText;
	}
	
	public WebElement SenderEmailAddressText() {
		Common_Utils.getInstance().highLightElemnts(SenderEmailAddressText);
		return SenderEmailAddressText;
	}

	public WebElement Individualcontactlist() {
		Common_Utils.getInstance().highLightElemnts(Individualcontactlist);
		return Individualcontactlist;
	}
	public WebElement Selectclasslistlabel() {
		Common_Utils.getInstance().highLightElemnts(Selectclasslistlabel);
		return Selectclasslistlabel;
	}
	public WebElement Classdropdown() {
//		Common_Utils.getInstance().waitForVisibility(Classdropdown, 5);
		Common_Utils.getInstance().highLightElemnts(Classdropdown);
		
		return Classdropdown;
	}
	public WebElement Parentname() {
		Common_Utils.getInstance().highLightElemnts(Parentname);
		return Parentname;
	}
	public WebElement Addallarrow() {
		Common_Utils.getInstance().waitForVisibility(Addallarrow, 5);
		Common_Utils.getInstance().highLightElemnts(Addallarrow);
		return Addallarrow;
	}
	public WebElement kalai_vanan() {
		Common_Utils.getInstance().waitForVisibility(kalai_vanan, 5);
		Common_Utils.getInstance().highLightElemnts(kalai_vanan);
		return kalai_vanan;
	}
	
	
	
	public void performSendByKeyword(String keyword) {
		List<WebElement> Msgcolumn = Driver_Manager.getDriver()
				.findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//td[2]"));
		System.out.println("Row count: " + Msgcolumn.size());
		for (WebElement messages :Msgcolumn) {
			try {
				String cellText = messages.getText().trim();
 
				if (cellText.contains(keyword)) {
					System.out.println("✅ Match found: " + cellText);
 
					WebElement Actions = Driver_Manager.getDriver()
							.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//*[contains(text(),'"+ keyword +"')]//following :: a[1]"));
					Actions.click();
					break;
				}
			} catch (Exception e) {
				System.out.println("" + keyword + " - Skipped (no valid cell or activate link)");
			}}}
	
	public void performEditByKeyword(String keyword) {
		List<WebElement> Msgcolumn = Driver_Manager.getDriver()
				.findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//td[2]"));
		System.out.println("Row count: " + Msgcolumn.size());
		for (WebElement messages :Msgcolumn) {
			try {
				String cellText = messages.getText().trim();
 
				if (cellText.contains(keyword)) {
					System.out.println("✅ Match found: " + cellText);
 
					WebElement Actions = Driver_Manager.getDriver()
							.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//*[contains(text(),'"+ keyword +"')]//following :: a[2]"));
					Actions.click();
					break;
				}
			} catch (Exception e) {
				System.out.println("" + keyword + " - Skipped (no valid cell or activate link)");
			}}}
	public void performDeleteByKeyword(String keyword) {
		List<WebElement> Msgcolumn = Driver_Manager.getDriver()
				.findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//td[2]"));
		System.out.println("Row count: " + Msgcolumn.size());
		for (WebElement messages :Msgcolumn) {
			try {
				String cellText = messages.getText().trim();
 
				if (cellText.contains(keyword)) {
					System.out.println("✅ Match found: " + cellText);
 
					WebElement Actions = Driver_Manager.getDriver()
							.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//*[contains(text(),'"+ keyword +"')]//following :: a[3]"));
					Actions.click();
					break;
				}
			} catch (Exception e) {
				System.out.println("" + keyword + " - Skipped (no valid cell or activate link)");
			}}}
	
//	public void identifyProcessingStatus(String keyword) {
//	    List<WebElement> msgColumn = Driver_Manager.getDriver()
//	            .findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//td[2]"));
//
//	    System.out.println("Row count: " + msgColumn.size());
//
//	    for (WebElement message : msgColumn) {
//	        try {
//	            String cellText = message.getText().trim();
//
//	            if (cellText.contains(keyword)) {
//	                System.out.println("✅ Match found: " + cellText);
//
//	                WebElement actionElement = Driver_Manager.getDriver()
//	                        .findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_GVCurrentTextCues']//td[contains(text(),'" + keyword + "')]/following-sibling::td[1]//a[1]"));
//	                break;
//	            }
//	        } catch (Exception e) {
//	            System.out.println(keyword + " - Skipped (no valid cell or action link)");
//	        }}}
}

package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormPge {
	public ContactFormPge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "contactId")
	private WebElement contactId;
	public WebElement getContactId() {
		return contactId;
	}
	
	@FindBy (name = "contactName")
	private WebElement contactName;
	public WebElement getContactName() {
		return contactName;
	}
	@FindBy (name = "organizationName")
	private WebElement orgName;
	public WebElement getOrgName() {
		return orgName;
	}
	@FindBy (name = "mobile")
	private WebElement mobile;
	public WebElement getMobile() {
		return mobile;
	}
	@FindBy (name = "title")
	private WebElement title;
	public WebElement getTitle() {
		return title;
	}
	@FindBy (xpath = "//*[local-name()='svg' and @data-icon='plus']")
	private WebElement plusBtn;
	public void clickPlusBtn() {
		plusBtn.click();
	}
	@FindBy (xpath = "//button[text()='Create Contact']")
	private WebElement saveContactBtn;
	public void clickSaveContactBtn() {
		saveContactBtn.click();
	}
}

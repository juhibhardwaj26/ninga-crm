package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	@FindBy (linkText = "Contacts")
	private WebElement contactLink;
	public void clickContactLink() {
		 contactLink.click();
	}
	@FindBy (xpath = "//*[local-name()='svg']")
	private WebElement profileIcon;
	public void clickProfileIcon() {
		profileIcon.click();
	}
	@FindBy (xpath = "//div[@class='dropdown-item logout']")
	private WebElement logoutBtn;
	public void clickLogOutBtn() {
		logoutBtn.click();
	}
	
}

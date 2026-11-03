package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampFormPage {
	public CampFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "campaignId")
	private WebElement campId;
	public WebElement getCampId() {
		return campId;
	}
	@FindBy (name = "campaignName")
	private WebElement campaignName;
	public WebElement getCampaignName() {
		return campaignName;
	}
	@FindBy (name = "targetSize")
	private WebElement targetSize;
	public WebElement getTargetSize() {
		return targetSize;
	}
	@FindBy (xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	public void clickCreateCampaign() {
		createCampaignBtn.click();
	}
}

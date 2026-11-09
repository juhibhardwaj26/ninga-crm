package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectCampFromName {
	public SelectCampFromName(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "search-criteria")
	private WebElement dropdown;
	public void dropDown() {
		Select sel = new Select(dropdown);
		sel.selectByValue("campaignName");
		
	}
	
	@FindBy (xpath = "//button[text()='Select']")
	private WebElement selectButton;
	public void clickSelectButton() {
		selectButton.click();
	}
}

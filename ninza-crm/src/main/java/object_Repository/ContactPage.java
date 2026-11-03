package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//span[text()='Create Contact']")
	private WebElement createContactBtn;
	public void clickCreateContactBtn() {
		createContactBtn.click();
	}
}

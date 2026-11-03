package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(id = "inputPassword")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}

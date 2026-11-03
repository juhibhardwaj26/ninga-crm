package baseUtility;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import fileUtility.FileUtility;
import object_Repository.HomePage;
import object_Repository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeClass
	public void setUp() throws IOException, ParseException {
		System.out.println("executing ...");

		String url = FileUtility.getDataFromJsonFile("url");

		String bro = FileUtility.getDataFromJsonFile("bro");

		if (bro.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (bro.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (bro.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}

	@BeforeMethod
	public void logIn() throws IOException, ParseException {
		System.out.println(driver);
		System.out.println(sdriver);
		String un = FileUtility.getDataFromJsonFile("un");
		String pwd = FileUtility.getDataFromJsonFile("pwd");
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(un);
		lp.getPassword().sendKeys(pwd);
		lp.getLoginBtn().click();
	}

	@AfterMethod
	public void logOut() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(4000);
		hp.clickProfileIcon();
		hp.clickLogOutBtn();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}

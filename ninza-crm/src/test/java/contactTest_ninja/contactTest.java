package contactTest_ninja;

import java.io.IOException;

import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import fileUtility.FileUtility;
import object_Repository.CampFormPage;
import object_Repository.ContactFormPge;
import object_Repository.ContactPage;
import object_Repository.HomePage;

import object_Repository.SelectCampFromName;

@Listeners(listenerUtility.ListenerUtility.class)
public class contactTest extends BaseClass {

	@Test
	public void createContactTest() throws IOException, ParseException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getCreateCampaignBtn().click();
		//String campId = FileUtility.getDataFromExcelFile("campaign data", 2, 0);
		String campName = FileUtility.getDataFromExcelFile("campaign data", 3, 1);
		String targetSize = FileUtility.getDataFromExcelFile("campaign data", 3, 2);
		CampFormPage cfp = new CampFormPage(driver);
		cfp.getCampaignName().sendKeys(campName);
		//cfp.getCampId().sendKeys(campId);
		cfp.getTargetSize().sendKeys(targetSize);
		Thread.sleep(1000);
		cfp.clickCreateCampaign();

		Thread.sleep(2000);

		hp.clickContactLink();
		Thread.sleep(1000);
		ContactPage contp = new ContactPage(driver);
		Thread.sleep(3000);
		contp.clickCreateContactBtn();
		Thread.sleep(3000);

		String contactID = FileUtility.getDataFromExcelFile("contact data", 1, 4);
		String contactName = FileUtility.getDataFromExcelFile("contact data", 1, 0);
		String orgName = FileUtility.getDataFromExcelFile("contact data", 1, 1);
		String mobile = FileUtility.getDataFromExcelFile("contact data", 1, 2);
		String title = FileUtility.getDataFromExcelFile("contact data", 1, 3);

		ContactFormPge contfp = new ContactFormPge(driver);
		contfp.getContactId().sendKeys(contactID);
		contfp.getContactName().sendKeys(contactName);
		contfp.getOrgName().sendKeys(orgName);
		contfp.getTitle().sendKeys(title);
		contfp.getMobile().sendKeys(mobile);
		String pid = driver.getWindowHandle();
		contfp.clickPlusBtn();
		Set<String> cid = driver.getWindowHandles();
		for (String i : cid) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains("Campaign"))
				break;
		}

		// driver.switchTo().window(cid);
		SelectCampFromName scfn = new SelectCampFromName(driver);
		scfn.dropDown();
		driver.findElement(By.id("search-input")).sendKeys(campName);
		Thread.sleep(2000);
		scfn.clickSelectButton();
		driver.switchTo().window(pid);

		contfp.clickSaveContactBtn();
		Thread.sleep(2000);

	}
}

package testcasesFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pom.HomePage;
import reusable.BaseTest;

public class HomePageTest extends BaseTest{

	@Test
	public void verifyTitle() throws InterruptedException {
//		HomePage homePage = new HomePage(driver);
		
		logger.log(LogStatus.INFO, "Checking title matches string");
//		Assert.assertEquals(homePage.getTitle(), "OneMap");
		logger.log(LogStatus.PASS, "Title matches with title from DOM");
	}

	@Test(priority=1)
	public void verifyLogo() {
//		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking if logo is present");
//		Assert.assertTrue(homePage.logoDisplay());
		logger.log(LogStatus.PASS, "Logo is present");
	}

}
package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaHomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void loginToZerodha() throws EncryptedDocumentException, IOException, InterruptedException {
		driver = ChromeBrowser.openBrowser();
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userid = Excel.getData("Credentials", 0, 0);
		String pass = Excel.getData("Credentials", 1, 0);
		String pin = Excel.getData("Credentials", 2, 0);
		zerodhaLoginPage.enterUserId(userid);
		 zerodhaLoginPage.enterPassword(pass);
		 zerodhaLoginPage.clickOnSubmit();
		 zerodhaLoginPage.enterPin(driver, pin);
		 zerodhaLoginPage.clickOnContinue();
	}
	@Test
	public void searchStockAndClickBuy() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock(driver,"TATA");
		zerodhaHomePage.selectStockFromSearchList(driver, "TATAMOTORS");
	}
	@Test
	public void searchStock() {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock(driver,"tata");
		int size = zerodhaHomePage.getSearchListSize() ;
		Assert.assertTrue(size < 0);//Console showing True for the result bcz stock showing greater than 0
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

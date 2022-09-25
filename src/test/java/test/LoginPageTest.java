package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.ChromeBrowser;
import pom.ZerodhaLoginPage;
import utility.Excel;

@Listeners(Listener.class)
public class LoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		driver = ChromeBrowser.openBrowser();
		
	}
	
	@Test
	public void loginZerodhaTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String title = driver.getTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
		String userid = Excel.getData("Credentials", 0, 0);
		String pass = Excel.getData("Credentials", 1, 0);
		Thread.sleep(2000);
		String pin = Excel.getData("Credentials", 2, 0);
		String search = Excel.getData("Credentials", 3, 0);
		zerodhaLoginPage.enterUserId(userid);
		 zerodhaLoginPage.enterPassword(pass);
		 zerodhaLoginPage.clickOnSubmit();
		 zerodhaLoginPage.enterPin(driver, pin);
		 zerodhaLoginPage.clickOnContinue();
		 zerodhaLoginPage.searchShares(search);
		 soft.assertAll();
		 	Thread.sleep(2000);
			WebElement openbuybutton = driver.findElement(By.xpath("//input[@type='text']"));
			Actions action = new Actions(driver);
			action.moveToElement(openbuybutton);
			action.perform();
			zerodhaLoginPage.buyShares();
	}
			
	}	 
	
	

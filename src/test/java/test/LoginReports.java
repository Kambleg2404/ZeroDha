package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.ChromeBrowser;
import pom.ZerodhaForgotIdPass;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class LoginReports {
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	@BeforeTest
	public void configureReports() {
		extent = Reports.generateReports();
		}
		@BeforeMethod
		public void launchBrowser() {
			driver = ChromeBrowser.openBrowser();
		}
		
		@Test
		public void loginZerodhaTest() throws EncryptedDocumentException, IOException, InterruptedException {
			test = extent.createTest("loginZerodhaTest");
			ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
			String title = driver.getTitle();
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
			String userid = Excel.getData("Credentials", 0, 0);
			String pass = Excel.getData("Credentials", 1, 0);
			Thread.sleep(2000);
			String pin = Excel.getData("Credentials", 2, 0);
			zerodhaLoginPage.enterUserId(userid);
			 zerodhaLoginPage.enterPassword(pass);
			 zerodhaLoginPage.clickOnSubmit();
			 zerodhaLoginPage.enterPin(driver, pin);
			 zerodhaLoginPage.clickOnContinue();
			 
			 soft.assertAll();
		}
		@Test
		public void verfySignUpFeature() {
			test = extent.createTest("verifySignUpFeatures");
			ZerodhaLoginPage zerodhLoginPage = new ZerodhaLoginPage(driver);
			zerodhLoginPage.clickOnsignUp();
		}
		
		@Test
		public void forgotIdPassTest() {
			ZerodhaForgotIdPass zerodhaForgotIdPass = new ZerodhaForgotIdPass(driver);
			zerodhaForgotIdPass.forgotIdPass();

		}
		
		@AfterMethod
		public void postExecution(ITestResult result) {
			if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, result.getName());
			}
			else if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, result.getName());
			}
			else {
				test.log(Status.SKIP, result.getName());
			}
		}
		
		@AfterTest
		public void publishReport() {
			extent.flush();
		}
		
}

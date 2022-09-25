package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.ChromeBrowser;
import pom.ZerodhaForgotIdPass;
import utility.Excel;

public class ForgotIdPassPage {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		extent = Reports.generateReports();
		}
	@BeforeMethod
	public void launchBrowser() {
		driver = ChromeBrowser.openBrowser();
}


	@Test
	public void forgotIdPassTest() throws InterruptedException, EncryptedDocumentException, IOException {
		ZerodhaForgotIdPass zerodhaForgotIdPass = new ZerodhaForgotIdPass(driver);
		String mobileNo = Excel.getData("Credentials", 6, 0);
		zerodhaForgotIdPass.forgotIdPass();
		Thread.sleep(2000);
		zerodhaForgotIdPass.clickOnUserID();
		String panNumber = Excel.getData("Credentials", 5, 0);
		Thread.sleep(2000);
		zerodhaForgotIdPass.panDetails(panNumber);
		Thread.sleep(2000);
		zerodhaForgotIdPass.clickMail();
		zerodhaForgotIdPass.mobileNo(mobileNo);
	}
	public void zerodhaForgotPasswordFeatureTest() {
		test = extent.createTest("zerodhaForgotPasswordFeatureTest");
		ZerodhaForgotIdPass zerodhaForgotIdPass = new ZerodhaForgotIdPass(driver);
		zerodhaForgotIdPass.forgotIdPass();
	}
		
}	
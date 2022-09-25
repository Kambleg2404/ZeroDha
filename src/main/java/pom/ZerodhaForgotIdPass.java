package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotIdPass {
	@FindBy(xpath="//a[@class='text-light forgot-link']")
	private WebElement forgotidpass;
	
	@FindBy(xpath="//label[@for='radio-31']")
	private WebElement clickonradioforgotuserid;
	
	
	@FindBy(xpath="(//input[@type='text'])[1]")private WebElement pandetails;
	@FindBy(xpath="(//label[@class='su-radio-label'])[4]")private WebElement receivetextmsg;
	@FindBy(xpath="//input[@placeholder='Mobile number (as on account)']")private WebElement fillmobileno;
	
	public ZerodhaForgotIdPass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void forgotIdPass() {
		forgotidpass.click();
	}
	public void clickOnUserID() {
		clickonradioforgotuserid.click();
	}
	
	public void panDetails(String panNumber) {
		pandetails.sendKeys(panNumber);
	}
	public void clickMail() {
		receivetextmsg.click();
	}
	public void mobileNo(String mobileNo) {
		fillmobileno.sendKeys(mobileNo);
	}
	
	}

	
	

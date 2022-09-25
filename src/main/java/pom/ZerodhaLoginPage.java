package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ZerodhaLoginPage {
	@FindBy(xpath="//input[@id='userid']")private WebElement userId;
	//WebElement userId = driver.findElement(By.xpath("//input[@id='userid']")); Both are working same,@FindBy
	@FindBy(xpath="//input[@id='password']")private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;
	@FindBy(xpath="//a[text()=\"Forgot user ID or password?\"]")private WebElement forgot;
	@FindBy(xpath="//input[@label='PIN']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement run;
	@FindBy(xpath="//input[@type='text']")private WebElement searchShares;
	@FindBy(xpath ="//button[@class='button-blue buy']")private WebElement buy;
		public ZerodhaLoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	public void enterUserId(String user) {
		userId.sendKeys(user);
	}
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	public void clickOnSubmit() {
		submit.click();
	}
	public void clickOnsignUp() {
		signUp.click();
	}
	public void enterPin(WebDriver driver, String pinNumber) {
		FluentWait<WebDriver>wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinue( ) {
		run.click();
	}
	public void searchShares(String search) {
		searchShares.sendKeys(search);
	}
	public void buyShares() {
		buy.click();
	}

}

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoExecution {
	String releaseDateImdb;
	String countryImdb;
	String releaseDateWiki;
	String countryWiki;
	
	@Test
	public void TestImdb() {
		WebElement element;
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.imdb.com/title/tt9389998/releaseinfo?ref_=tt_dt_rdat");
		driver.manage().window().maximize();
		element = driver.findElement(By.xpath("//*[@id=\"releaseinfo_content\"]/table[1]/tbody/tr[6]/td[2]"));//*[@id="releaseinfo_content"]/table[1]/tbody/tr[6]/td[2]
		releaseDateImdb = element.getText();
		element = driver.findElement(By.xpath("//*[@id=\"releaseinfo_content\"]/table[1]/tbody/tr[6]/td[1]"));
		countryImdb = element.getText();
		System.out.println("Release date is "+releaseDateImdb+" and country is "+countryImdb);
		driver.quit();
	}
	
	@Test
	public void TestWiki() {
		WebElement element;
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		driver.manage().window().maximize();
		element = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td"));
		releaseDateWiki = element.getText();
		element = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td"));
		countryWiki = element.getText();
		System.out.println("Release date is "+releaseDateWiki+" and country is "+countryWiki);
		Assert.assertEquals(releaseDateImdb, releaseDateWiki);
		Assert.assertEquals(countryImdb, countryWiki);
		driver.quit();
	}
}

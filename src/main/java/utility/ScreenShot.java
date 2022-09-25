package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void takeScreenShot(WebDriver driver, String name) throws IOException {
		String date = getDate();
		TakesScreenshot ts  = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("E:\\Screenshots");
		
		FileHandler.copy(source, destination);
	}
	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");
		LocalDateTime currentTime = LocalDateTime.now();
		String d = dtf.format(currentTime);
		return d;
		
	}
}

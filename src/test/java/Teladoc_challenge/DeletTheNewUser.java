package Teladoc_challenge;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DeletTheNewUser {
public static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	SetUpBrowsers("chrome", "http://www.way2automation.com/angularjs-protractor/webtables/");

	
		
	
	
	
	
	
	
	
	
	
	
	
	}
public static void SetUpBrowsers(String browser, String url) {
if (browser.equalsIgnoreCase("chrome")) {
System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get(url);
driver.navigate().refresh();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());	
} else if(browser.equalsIgnoreCase("firefox")) {
System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
driver.get(url);
driver.get(url);
driver.navigate().refresh();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());		
} else if (browser.equalsIgnoreCase("InterNetbrowser")) {
System.setProperty("webdriver.ie.driver", ".\\drivers\\ID.exe");
driver = new InternetExplorerDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get(url);
driver.navigate().refresh();
//System.out.println(driver.getTitle());
//System.out.println(driver.getCurrentUrl());
}else {
System.out.println("please try the corrct browser");	
}
}
public static void TakeScreenshots(WebDriver driver, String fileName) throws IOException {	
	String  path = ".\\ScreeShots\\";
	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(path+fileName+".png"));

}
}
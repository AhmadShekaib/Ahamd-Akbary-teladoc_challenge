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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddingNewUser {	
public static WebDriver driver;
public static void main(String[] args) throws IOException {
		SetUpBrowsers("chrome", "http://www.way2automation.com/angularjs-protractor/webtables/");

		WebElement AddUser = driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']"));
		AddUser.click();
		TakeScreenshots(driver, "Pic-001");
		
		
		System.out.println("WebTable name is.. " +driver.getTitle());
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Protractor practice website - WebTables";
		
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
			System.out.println("WebTable Exist in the webbrowser..");
		} else {
			Assert.assertFalse(false);
			System.out.println("WebTable Doe Not Exist in the webbrowser..");
		}
		
		String actualURl = driver.getCurrentUrl();
		String expectedUrl = "";
		
		if (actualURl.contains(expectedUrl)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
			
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		WebElement UserName = driver.findElement(By.xpath("//input[@name='UserName']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='Password']"));
		WebElement Customer = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
	
				FirstName.clear();
				LastName.clear();
				UserName.clear();
				Password.clear();
				Customer.click();
		
		
		System.out.println("Confirming FirstName is displayed and Enabled\t"+FirstName.isDisplayed()+ ":"+FirstName.isEnabled());
		System.out.println("Confirming LastName is displayed and Enabled\t"+LastName.isDisplayed()+ ":"+FirstName.isEnabled());
		System.out.println("Confirming UserName is displayed and Enabled\t"+UserName.isDisplayed()+ ":"+FirstName.isEnabled());
		System.out.println("Confirming Password is displayed and Enabled\t"+Password.isDisplayed()+ ":"+FirstName.isEnabled());
		System.out.println("Confirming Cusomer button is displayed and Enabled\t"+Password.isDisplayed()+ ":"+FirstName.isEnabled());
	
				FirstName.sendKeys("Ahmad");
				LastName.sendKeys("Shekaib");
				UserName.sendKeys("SDET-Engineer");
				Password.sendKeys("ILoveAutomation");
				
		
		
		
		WebElement Role = driver.findElement(By.xpath("//select[@class='ng-pristine ng-invalid ng-invalid-required']"));
		Select select = new Select(Role);
				select.selectByIndex(2);
			//	select.selectByValue(value);
			//	select.selectByVisibleText(text);
				
		
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='Email']"));
		WebElement CellPhone = driver.findElement(By.xpath("//input[@name='Mobilephone']"));
				Email.clear();
				CellPhone.clear();
			
			
			System.out.println("Confirming Email is displayed and Enabled\t"+Email.isDisplayed()+ ":"+Email.isEnabled());
			System.out.println("Confirming CellPhone is displayed and Enabled\t"+CellPhone.isDisplayed()+ ":"+CellPhone.isEnabled());
			
			Email.sendKeys("SDET_Engineer@yahoo.com");
			CellPhone.sendKeys("125-512-2415");
			TakeScreenshots(driver, "Pic-001"); //ScreenShots
	
	
		WebElement clickOnSaveButton =	driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		
			if(clickOnSaveButton.isDisplayed()) {
				clickOnSaveButton.click();
				
				System.out.println("AddUser Test is passed");
			}else {
				System.out.println("AddUser Test is failed");
			}

	
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
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getCurrentUrl());	
} else if(browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get(url);
	driver.get(url);
	driver.navigate().refresh();
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getCurrentUrl());		
} else if (browser.equalsIgnoreCase("InternetExplorer")) {
	System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	driver.navigate().refresh();
//	System.out.println(driver.getTitle());
//	System.out.println(driver.getCurrentUrl());
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
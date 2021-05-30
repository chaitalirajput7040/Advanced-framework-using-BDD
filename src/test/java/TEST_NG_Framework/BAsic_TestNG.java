package TEST_NG_Framework;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BAsic_TestNG {
 WebDriver driver;
  @BeforeMethod
  @Parameters({"Browser"})
  public void beforeTest(String browser) {
	  if(browser.equalsIgnoreCase("chrome"))
	  {
			 WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
			 driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("IE"))
	  {
		  WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
	  }
	  else if(browser.equalsIgnoreCase("Firefox"))
	  {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("headless"))
	  {
		  WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
			
		    ChromeOptions options = new ChromeOptions();
		    options.setHeadless(true);
		    driver = new ChromeDriver(options);
	  }
	  else
	  {
		  System.out.println("Oops the browser is not supported!!!");
	  }
  }

  @Test(dataProvider="data-provider")
  public void test1(String data) throws InterruptedException
  {
	  driver.get("https://www.facebook.com");
	  Thread.sleep(3000);
	  driver.findElement(By.name("email")).sendKeys(data);
	  System.out.println(driver.getTitle());
	
  }
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
	
  }
  
  @DataProvider(name="data-provider")
  public Object[][] dataproviderMethod()
  {
	  return new Object[][] {{"8857956365"},{"chaitali@7040"}};
  

}
}

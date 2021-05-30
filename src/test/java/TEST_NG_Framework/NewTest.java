package TEST_NG_Framework;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	 WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("https://touch.facebook.com/?_rdr");
	  Thread.sleep(4000);
  }
  @BeforeMethod
  @Parameters({"Browser"})
  public void beforeMethod(String browser) {
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
	  else
	  {
		  System.out.println("Oops the browser is not supported!!!");
	  }
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}

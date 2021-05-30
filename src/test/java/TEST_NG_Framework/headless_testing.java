package TEST_NG_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class headless_testing {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.name("email")).sendKeys("chaitss");
	  Thread.sleep(3000);
  }
  @BeforeTest
  public void beforeMethod()  {
	  HtmlUnitDriver  driver = new HtmlUnitDriver();
	  driver.get("https://www.facebook.com/");
	
	
  }

  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }

}

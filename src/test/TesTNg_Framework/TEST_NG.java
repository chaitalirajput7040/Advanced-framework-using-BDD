package TesTNg_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TEST_NG {

  @BeforeTest
  @Parameters({"Browser"})
  public void beforeTest(String browser) {
	  if(browser.equalsignorecase("chrome"))
	  {
		  
	  }
	  else  if(browser.equalsignorecase("IE"))
	  {
      }
	  else if(browser.equalsignorecase("IE"))

  @AfterTest
  public void afterTest() {
  }
  
  @Test
  public void f() {
  }

}

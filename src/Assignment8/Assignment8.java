package Assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment8 {
	
	public WebDriver driver;
	
  @Test
  public void discountCoupon() {
	  
	  driver.findElement(By.xpath("//div[@id='header-nav']/nav/ol/li[1]/a")).click();
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click();
	  driver.findElement(By.cssSelector("input[id='coupon_code']")).sendKeys("GURU50");
	  driver.findElement(By.cssSelector("button[title='Apply']")).click();
	  
	  //verify Discount
	  
	  String subtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")).getText();
	  String discount=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	  String grandtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
      System.out.println("subtotal"+subtotal);
	  System.out.println("discount"+discount);
	  System.out.println("grandtotal"+grandtotal);
	  
	  String discounttotal="$475";
	  
	  if(grandtotal.equalsIgnoreCase(discounttotal))
	  {
		  System.out.println("Discount CouponVerified");
		  System.out.println("Price is discounted by 5%");
		  
	  }
	  else
	  {
	  System.out.println("Discount Coupon Not Verified");
	  System.out.println("Price is not discounted by 5%");
	  }
  
  
  }
  
  @BeforeClass
  public void mximizeBrowser() {
	
	  driver.manage().window().maximize();
	  
  }

  @BeforeTest
  public void enterApplicationUrl() {
	  driver.get("http://live.guru99.com");
  }

  @BeforeSuite
  public void openBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaydeep\\Desktop\\Selenium Testing Material\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }
}

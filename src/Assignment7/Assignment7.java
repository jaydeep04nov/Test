package Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment7 {
	
	public WebDriver driver;
	
  @Test
  public void reorder() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2]")).click();
	  driver.findElement(By.cssSelector("[id='header-account'] [ title='My Account']")).click();
	  
	  //Login
	  
	  driver.findElement(By.cssSelector("input[name='login[username]']")).sendKeys("jaydeep04nov@gmail.com");
	  driver.findElement(By.cssSelector("input[title='Password']")).sendKeys("Jsm00007!");
	  driver.findElement(By.cssSelector("button[title='Login']")).click();
	  
	  //Reorder
	  
	  driver.findElement(By.cssSelector("a[class='link-reorder']")).click();
	  driver.findElement(By.cssSelector("input[title='Qty']")).sendKeys("0");
	  driver.findElement(By.cssSelector("[class='product-cart-actions'] [value='update_qty']")).click();
	  
	
	  
	  WebElement country=driver.findElement(By.cssSelector("select[name='country_id']"));
	  country.click();
	  Select sel=new Select(country);
	  sel.selectByVisibleText("United States");
	  
	  WebElement city=driver.findElement(By.cssSelector("select[title='State/Province']"));
	  city.click();
	  Select sel1=new Select(city);
	  sel1.selectByVisibleText("New York");
	  
	  driver.findElement(By.cssSelector("input[id='postcode']")).sendKeys("542896");
	 
	  //Estimation
	  
	  driver.findElement(By.cssSelector("button[title='Estimate']")).click();
	  driver.findElement(By.cssSelector("input[value='flatrate_flatrate']")).click();
	  System.out.println("Flat Rate of $5 is generated");
	  driver.findElement(By.cssSelector("button[title='Update Total']")).click();
	  
      //Verify
	  
	  String oldGT="$620";
	  System.out.println("Old GrandTotal :"+oldGT);
	  String newGT=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
      System.out.println("GrandTotal Updated :" +newGT);
      
      
      //Checkout
	  
	  driver.findElement(By.cssSelector("[class='method-checkout-cart-methods-onepage-bottom'] [title='Proceed to Checkout']")).click();
  
  
      //Shipping information
	  
	  driver.findElement(By.cssSelector("button[onclick='billing.save()']")).click();
      Thread.sleep(2000);
      
      
      //Billing information
      
      driver.findElement(By.cssSelector("button[onclick='shippingMethod.save()']")).click();
      Thread.sleep(2000);
      
      driver.findElement(By.cssSelector("input[title='Check / Money order']")).click();
     
      
      driver.findElement(By.cssSelector("button[onclick='payment.save()']")).click();
      Thread.sleep(2000);
  
      driver.findElement(By.cssSelector("button[onclick='review.save();']")).click();
      Thread.sleep(2000);
      System.out.println("Order is Placed");
      
      String orderno=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/p[1]/a")).getText();
	  System.out.println("Order Number Generated :"+orderno);
      
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

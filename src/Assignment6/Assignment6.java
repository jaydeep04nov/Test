package Assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment6 {
	
	public WebDriver driver;
  @Test
  public void purchaseproducct() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2]")).click();
	  driver.findElement(By.cssSelector("[id='header-account'] [ title='My Account']")).click();
	  
	  //Login
	  
	  driver.findElement(By.cssSelector("input[name='login[username]']")).sendKeys("jaydeep04nov.mech@gmail.com");
	  driver.findElement(By.cssSelector("input[title='Password']")).sendKeys("Jsm00007!");
	  driver.findElement(By.cssSelector("button[title='Login']")).click();
	  
	  //WishList
	  
	  driver.findElement(By.xpath("//div[@class='block-content']/ul/li[8]/a")).click();
	  driver.findElement(By.cssSelector("button[title='Add to Cart']")).click();
	  
	  //Shipping information
	  
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
	  
	  //Verify Total
	  
	/* String subtotal= driver.findElement(By.cssSelector("[class='info-wrapper'] [class='price']")).getText();
     int subtotal1=Integer.parseInt(subtotal) ;
     System.out.println(subtotal1);
     
     String shiptax=driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
     int shiptax1=Integer.parseInt(shiptax);
     System.out.println(shiptax1);
     
     int total=subtotal1+shiptax1;
     String grandtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
     int grandtotal1=Integer.parseInt(grandtotal);
     System.out.println(grandtotal1);
     
     if(total==grandtotal1)
     {
    	 System.out.println("GrandTotl is Verified");
     }*/
	  
	  //Checkout
	  
	  driver.findElement(By.cssSelector("[class='method-checkout-cart-methods-onepage-bottom'] [title='Proceed to Checkout']")).click();
     
     //Billing Information
	  
	  driver.findElement(By.cssSelector("input[id='billing:street1']")).sendKeys("ABC");
	  driver.findElement(By.cssSelector("input[name='billing[city]']")).sendKeys("New York");
	  WebElement obj=driver.findElement(By.xpath("//div[@class='input-box']/select[@id='billing:region_id']"));
	  obj.click();
	  Select sel3=new Select(obj);
	  sel3.selectByVisibleText("New York");
	  driver.findElement(By.cssSelector("input[id='billing:postcode']")).sendKeys("542896");
	  WebElement obj1=driver.findElement(By.xpath("//div[@class='input-box']/select[@id='billing:country_id']"));
	  obj1.click();
	  Select sel4=new Select(obj1);
	  sel4.selectByVisibleText("United States");
	  driver.findElement(By.cssSelector("input[name='billing[telephone]']")).sendKeys("123456789");
	  driver.findElement(By.cssSelector("button[onclick='billing.save()']")).click();
	  
	  //Shipping information
	  Thread.sleep(4000);
	  driver.findElement(By.cssSelector("button[onclick='shippingMethod.save()']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.cssSelector("input[title='Check / Money order']")).click();
	  driver.findElement(By.cssSelector("button[onclick='payment.save()']")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.cssSelector("button[title='Place Order']")).click();
	  System.out.println("Order is Placed");
	  Thread.sleep(4000);
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

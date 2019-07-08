package Assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment9 {
	
	public WebDriver driver;
  @Test
  public void export() {
	

	  
	  //Login
	  
	  driver.findElement(By.cssSelector("input[id='username']")).sendKeys("user01");
	  driver.findElement(By.cssSelector("input[type='password']")).sendKeys("guru99com");
	  driver.findElement(By.cssSelector("input[type='submit']")).click();
	  
	 //Alert
	  
	  driver.findElement(By.cssSelector("a[title='close']")).click();
	  
	  //Mouse Hover
	  
	  WebElement obj=driver.findElement(By.xpath("//ul[@id='nav']/child::li[1]"));
	  Actions action=new Actions(driver);
	  action.moveToElement(obj).build().perform();
	  
	  //Orders
	  
	  driver.findElement(By.xpath("//li[@class='  level1']/child::a")).click();
	  
	  //DropDown
	  
	  WebElement obj1=driver.findElement(By.cssSelector("[name='sales_order_grid_export']"));
	  obj1.click();
	  
	  Select sel=new Select(obj1);
	  sel.selectByVisibleText("CSV");
	  
	  driver.findElement(By.cssSelector("button[title='Export']")).click();
	  
	  System.out.println("File Downloaded Successfully");
  }
  
  @BeforeClass
  public void mximizeBrowser() {
	
	  driver.manage().window().maximize();
	  
  }

  @BeforeTest
  public void enterApplicationUrl() {
	  driver.get("http://live.guru99.com/index.php/backendlogin");
  }

  @BeforeSuite
  public void openBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaydeep\\Desktop\\Selenium Testing Material\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }
}

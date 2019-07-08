package Assignment10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
public static void main(String[] args) {
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaydeep\\Desktop\\Selenium Testing Material\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.echoecho.com/htmlforms10.htm");
	driver.manage().window().maximize();
	
	
	//Find the number of radio buttons in section1 and section2 on website
	
	WebElement obj=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
	List<WebElement> radio=obj.findElements(By.cssSelector("input[type='radio']"));
	int count=radio.size();
	System.out.println("Number of Radio Buttons :-"+ count);
	
	WebElement group1=driver.findElement(By.cssSelector("input[name='group1']"));
	group1.click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}

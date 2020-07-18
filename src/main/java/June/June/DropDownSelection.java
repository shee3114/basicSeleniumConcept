package June.June;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownSelection 
{
	@Test
    public void openPage(){
    	
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("http://output.jsbin.com/osebed/2");
		String title = driver.getTitle();
		System.out.println("Title is: " + title); 
		
		WebElement Dropdownlocator = driver.findElement(By.xpath("//*[@id='fruits']"));
		
		Select dropDown = new Select (Dropdownlocator);
		dropDown.selectByValue("apple");
		//Other options are dropDown.ByVisbleText and dropDown.ByIndex
    }
}

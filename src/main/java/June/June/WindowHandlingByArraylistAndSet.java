package June.June;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlingByArraylistAndSet {

	@Test
	public void handleWindow() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://the-internet.herokuapp.com/windows");

		driver.manage().window().maximize();

		WebElement clicklink = driver.findElement(By.xpath("//a[@target='_blank']"));
		clicklink.click();
		
		Set<String> handle = driver.getWindowHandles();

		ArrayList<String> tabs = new ArrayList<String>(handle);

		for (String str : tabs) {
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
			driver.close();
		}
	}
}

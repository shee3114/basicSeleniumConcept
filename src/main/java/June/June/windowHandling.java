package June.June;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class windowHandling {

	@Test
	public void windowHandling() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://the-internet.herokuapp.com/windows");

		driver.manage().window().maximize();

		WebElement clicklink = driver.findElement(By.xpath("//a[@target='_blank']"));
		clicklink.click();
		//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Set<String> tabs = driver.getWindowHandles();
		for (String i : tabs) {
			driver.switchTo().window(i);
			System.out.println(driver.getTitle());
			driver.close();
		}
	}
}

// ArrayList <String> tabs = new ArrayList<String>(driver.getWindowHandles());
// for(int i = 0; i <tabs.size(); i++){
// driver.switchTo().window(tabs.get(i));
// System.out.println(driver.getTitle());
// driver.close();
// }
//

package navigationMethodsAndWindowHandle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 */

public class GetWindowHandleDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>WindowID = driver.getWindowHandles();
		
		/*
		 * Convert set[set do not have get method as it do not have index - so convert set to list]to list
		 */
		
		List <String> windowList = new ArrayList(WindowID);
		String parentID = windowList.get(0);
		String childID = windowList.get(1);
		
		/*
		 * Driver will be focused only on parent window only
		 */
		System.out.println(driver.getTitle());
		
		/*
		 * Switching to child window.
		 */
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		/*
		 * Switching to parent window
		 */
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		
		
		
	}
	
	
	
	

}

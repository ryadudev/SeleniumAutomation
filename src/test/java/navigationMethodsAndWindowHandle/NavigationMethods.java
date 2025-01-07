package navigationMethodsAndWindowHandle;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NavigationMethods {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();

//		driver.get("https://demo.nopcommerce.com");

		/*
		 * navigate.to(url) : work same as get(url). get : take url as string to() :
		 * internally it will call get() method only. Here we can pass url as String as
		 * well as object. URL OBJECT: URL myURL= new URL(url)
		 */

		/*
		 * Below line use String as parameter
		 */
//		driver.navigate().to("https://demo.nopcommerce.com");

		/*
		 * URL OBJECT : here url object is used as parameter.
		 */
		URL myurl = new URL("https://demo.nopcommerce.com");
		driver.navigate().to(myurl);

//		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		/*
		 * below line will refresh/reload the page
		 */
		driver.navigate().refresh();
		
		/*
		 * 
		 */
	}

}



package fyndProject;


import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReusableMethods {
/* *@author Vishal
 *  
 */
	// We have created page object here 
	@FindBy(xpath="//a[text()='Home']") WebElement home;
	@FindBy(xpath="//a[text()='Football']") WebElement football;
	@FindBy(xpath="//a[text()='Busketball']") WebElement basketball;
	@FindBy(xpath="//a[text()='Kriket']") WebElement cricket;
	@FindBy(xpath="//a[text()='Cibersport']") WebElement cyberSports; 
	
		public WebDriver driver ;
		
		// Method for launch the desired Browser  
		public void browserLaunch(String browser , String URL) {
			if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();	
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}
			driver.get(URL);
		}
		
		// method for close the driver 
		public void close() {
			driver.close();
		}
		
		// method for verify that url having tab name or not 
		public void verify(String Tab_name) {
			String str = driver.getCurrentUrl();
			if(str.contains(Tab_name)) {
				System.out.println("In "+Tab_name+"_tab URL "+Tab_name+" is present .");
			}
			else {
				System.out.println("In "+Tab_name+"_tab URL "+Tab_name+" is not present .");
			}
		}
		
		// Method for click on different different tabs
		public void click(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		

}

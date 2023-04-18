package fyndProject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestCases extends ReusableMethods{
  @Test(priority=1)
  public void Tab_Availability_test() {
	  // import the page object method using page Factory property 
	  ReusableMethods P = PageFactory.initElements(driver, ReusableMethods.class);
     
		// check for Home Tab
	    boolean a =  P.home.isDisplayed();
        SoftAssert s = new SoftAssert();
        try {
            s.assertEquals(a, true);
        } catch (AssertionError e) {
            System.out.println("Not Available");
            throw e;
        }
        System.out.println("Home tab is available");
		// check for FootBall Tab
		boolean b= P.football.isDisplayed();
		try {
            s.assertEquals(b, true);
        } catch (AssertionError e) {
            System.out.println("Not Available");
            throw e;
        }
        System.out.println("Footbal tab is available");
		// check for BasketBall Tab
		boolean c= P.basketball.isDisplayed();
		try {
            s.assertEquals(c, true);
        } catch (AssertionError e) {
            System.out.println("Not Available");
            throw e;
        }
        System.out.println("Basketball tab is available");
		// check for Cricket Tab
		boolean d= P.cricket.isDisplayed();
		try {
            s.assertEquals(d, true);
        } catch (AssertionError e) {
            System.out.println("Not Available");
            throw e;
        }
        System.out.println("Cricket tab is available");
		// check for Cyber Sports Tab
		boolean e = P.cyberSports.isDisplayed();
		try {
            s.assertEquals(e, true);
        } catch (AssertionError ex) {
            System.out.println("Not Available");
            throw ex;
        }
        System.out.println("CyberSports tab is available");
  }
  
@Test(priority=2)
public void Verify_URL() {
	  // verify for Home Tab
	  verify("Home");	  
	  // Verify for Footballl Tab
	  click("//a[text()='Football']");
	  verify("football");
	  // verify for Basketball Tab 
	  click("//a[text()='Busketball']");
	  verify("busketball");
	  // verify for Cricket Tab
	  click("//a[text()='Kriket']");
	  verify("kriket");
	  // verify for Ciber Sports Tab
	  click("//a[text()='Cibersport']");
	  verify("cibersport");
}

@Test(priority=3)
public void Add_Url() throws Exception {
	FileOutputStream fo = new FileOutputStream("C:\\Users\\HP\\OneDrive\\Desktop\\Fynd_Project(URL_Stored).xls");
	WritableWorkbook wwb = Workbook.createWorkbook(fo);
	WritableSheet ws= wwb.createSheet("Result", 1);
	String URL,Tab_name;
	// Store URL For Home Page Tab
	click("//a[text()='Home']");
	URL = driver.getCurrentUrl();
	Tab_name="Home";
	Label l1 = new Label(0,0,Tab_name+" tab Having the URL is:- "+URL);
	ws.addCell(l1);
	// Store URL for Football tab
	click("//a[text()='Football']");
	URL = driver.getCurrentUrl();
	Tab_name="Football";
	Label l2 = new Label(0,1,Tab_name+" tab Having the URL is:- "+URL);
	ws.addCell(l2);
	// Store URL for Basketball tab
	click("//a[text()='Busketball']");
	URL = driver.getCurrentUrl();
	Tab_name="Basketball";
	Label l3 = new Label(0,2,Tab_name+" tab Having the URL is:- "+URL);
	ws.addCell(l3);
	// Store URL for Cricket tab
	click("//a[text()='Kriket']");
	URL = driver.getCurrentUrl();
	Tab_name="Cricket";
	Label l4 = new Label(0,3,Tab_name+" tab Having the URL is:- "+URL);
	ws.addCell(l4);
	// Store URL for Ciber Sports tab
	click("//a[text()='Cibersport']");
	URL = driver.getCurrentUrl();
	Tab_name="Ciber Sports";
	Label l5 = new Label(0,4,Tab_name+" tab Having the URL is:- "+URL);
	ws.addCell(l5);
	wwb.write();
	wwb.close();
	
	System.out.println("URL of each tab is succefully added into Output Excel Sheet ");
}

  @BeforeTest
  public void beforeTest() {
	  browserLaunch("chrome","https://test-nf.com/english.html");
  }
  
  @AfterTest
  public void afterTest() {
	  close();
  }

}

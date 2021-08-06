package SeleniumTraining;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

public class Ejercicio2_Test {

	private WebDriver driver;
	Ejercicio2Automation testpage;
	String site = "https://testappautomation.herokuapp.com/";

	@BeforeTest
	public void setUp() throws Exception {
		testpage = new Ejercicio2Automation(driver);
		driver = testpage.chromeDriverConnection();
		driver.manage().window().maximize();
		testpage.visit(site);     
	}

	@Test
	public void test() throws InterruptedException {

		testpage.validateUnloggedHome();
		testpage.validateFooter();
		testpage.validateInvalidLogin();
		testpage.visit(site);
		testpage.validateValidLogin();
		testpage.validateLoggedHome();
	}
/*
 *Prueba que se ejecuta si la anterior falla
	@Test(priority = 2)
	public void test2() throws InterruptedException {
		testpage.validateValidLogin();
		testpage.validateLoggedHome();
	}
*/
	
	@AfterTest
	public void tearDown() throws Exception {
		//        driver.quit();
	}    
}
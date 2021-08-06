package SeleniumTraining;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejercicio4_Test {

	private WebDriver driver;
	Ejercicio4Automation testpage;
	String site = "https://testappautomation.herokuapp.com/";

	@BeforeTest
	public void setUp() throws Exception {
		testpage = new Ejercicio4Automation(driver);
		driver = testpage.chromeDriverConnection();
		driver.manage().window().maximize();
		testpage.visit(site);
	}

	@Test
	public void test() throws InterruptedException {

		// ### ACA SE DECLARAN LAS LLAMADAS A LOS METODOS### Ejemplo:
		 testpage.login();
		testpage.login();
		testpage.validateHeaderFooter();
		testpage.validateTitle();
		testpage.fillForm();
		testpage.validateResultPage();
		testpage.logOut();
	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.quit();
	}
}
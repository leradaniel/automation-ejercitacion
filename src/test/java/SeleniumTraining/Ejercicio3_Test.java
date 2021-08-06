package SeleniumTraining;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejercicio3_Test {

	private WebDriver driver;
	Ejercicio3Automation testpage;
	String site = "https://testappautomation.herokuapp.com/";

	@BeforeTest
	public void setUp() throws Exception {
		testpage = new Ejercicio3Automation(driver);
		driver = testpage.chromeDriverConnection();
		driver.manage().window().maximize();
		testpage.visit(site);
	}

	@Test
	public void test() throws InterruptedException {

		// Aca van los metodos de los testeos en Ejercicio3Automation. Ejemplo:
		testpage.login();
		testpage.validateHeaderFooter();
		testpage.validateNewsText();
		testpage.validateHiddenText();
		testpage.validateTitle();
		testpage.validateSections();
		testpage.validateLinksOnSamePage();
	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.quit();
	}
}
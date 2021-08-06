package SeleniumTraining;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 


public class Ejercicio1_Test {

	private WebDriver driver;
	Ejercicio1Automation googlepage;

	@BeforeTest
	public void setUp() throws Exception {
		googlepage = new Ejercicio1Automation(driver);
		driver = googlepage.chromeDriverConnection();
		driver.manage().window().maximize();
		googlepage.visit("https://www.google.com/");     
	}


	@Test
	public void test() throws InterruptedException {

		googlepage.searchInGoogle();
		googlepage.performAssertions(); 
	}

	@AfterTest
	public void tearDown() throws Exception {
		//        driver.quit();
	}    
}
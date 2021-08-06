package SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Libreria para inputs
//import org.openqa.selenium.Keys;

public class Ejercicio1Automation extends Base {
	//selectores
	By searchGoogle = By.name("q");
	//Por selector
	By searchButton = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.lJ9FBc > center > input.gNO89b");
	By firstLink = By.cssSelector("[class='yuRUbf'] > a");
	//Por xpath
	//	By searchButton = By.xpath("//*[/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]]");
	//Otro xpath
	////*[contains(@class,'gNO89b') and contains(@name,'btnK')][1] 

	public Ejercicio1Automation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchInGoogle() {
		click(searchGoogle);
		type("Selenium", searchGoogle);
		WaitForElement(searchButton);
		click(searchButton);
		WaitForElement(firstLink);
		click(firstLink);
	}

	public void performAssertions() {
		String title = driver.getTitle();
		Assert.assertEquals("SeleniumHQ Browser Automation", title);    
	}
}
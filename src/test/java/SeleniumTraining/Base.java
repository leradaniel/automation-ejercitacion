package SeleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {



	protected WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}
	public String getText(By locator) {
		return driver.findElement(locator).getText();    
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}


	public void click(By locator) {
		driver.findElement(locator).click();        
	}

	public Boolean checkIfElementisDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchContextException e) {
			return false;
		}

	}

	public void WaitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}


	public void ScrollToElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void switchToTab(int number) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(number));
	}


	public void clickelementByJQuery(String locator) {
		JavascriptExecutor jQuery = (JavascriptExecutor)driver;
		jQuery.executeScript(locator);

	}

	public void visit(String url) {
		driver.get(url);    
	}
}
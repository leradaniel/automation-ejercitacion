package SeleniumTraining;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Ejercicio3Automation extends Base {

	//Aca se declaran las variables
	By loginButton = By.id("loginBTN");
	By fieldUsername = By.id("username");
	By fieldPassword = By.id("password");
	By buttonContinue = By.className("c17fd62fe");

	By logoutButton = By.id("logoutBTN");
	By loremLink = By.cssSelector("a[href='/lorem/']");
	By footer = By.className("footerClass");
	By news = By.id("news");
	
	By avatarPicture = By.id("profileIMG");
	By userMessage = By.id("profileTXT");
	
	By hiddenText = By.id("hiddenText1");
	
	By sectionQueEsHead = By.id("headingObj1");
	By sectionPorQueHead = By.id("headingObj2");
	By sectionDeDondeHead = By.id("headingObj3");
	By sectionDondePuedoHead = By.id("headingObj4");
	
	By linkYoutube = By.xpath("*//*[@data-testid='TXTHyperLink1']");
	By linkFacebook = By.xpath("*//*[@data-testid='TXTHyperLink2']");
	By linkSelenium = By.xpath("*//*[@data-testid='TXTHyperLink3']");
	
	public Ejercicio3Automation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	// Aca se van agregando los metodos para testear.	
	public void login() {
		// Entrar al login
		WaitForElement(loginButton);
		click(loginButton);
		WaitForElement(fieldUsername);
		
		// Usuario y contraseña validos
		click(fieldUsername);
		type("mailfalsolala@gmail.com", fieldUsername);
		click(fieldPassword);
		type("!Unodos12", fieldPassword);
		click(buttonContinue);
		WaitForElement(logoutButton);
		
		//Entrar a Lorem Ipsum
		click(loremLink);
		WaitForElement(news);
	}
	
	public void validateHeaderFooter() {
		//Header
		// Verificar que el boton logout existe
		WaitForElement(logoutButton);

		// Verificar que se muestra nuestra imagen de avatar
		checkIfElementisDisplayed(avatarPicture);

		// Verificar el mensaje para usuario "mailfalsolala"
		String expectedMessage = "Welcome mailfalsolala !";
		String actualMessage = getText(userMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
		
		//Footer
		// Validar que el footer sea fixed
		String footerPosition = findElement(footer).getCssValue("position");
		Assert.assertEquals(footerPosition, "fixed");

		// Validar que esté abajo de todo
		String footerbottom = findElement(footer).getCssValue("bottom");
		Assert.assertEquals(footerbottom, "0px");

		// Validar que el texto sea el correcto
		String textoDisclaimer = "Disclaimer: This project is a personal site meant to be used as a help test site to be able to perform some automation test on demand.";
		String textoFooter = getText(footer);
		Assert.assertEquals(textoFooter, textoDisclaimer);
	}
	
	public void validateNewsText() {
		//Validar que el texto de news sea el correcto
		WaitForElement(news);
		String expectedNewsText = "Notice: This is a testing site meant to be used for automation test trainings";
		String newsText = getText(news);
		Assert.assertEquals(expectedNewsText, newsText);
	}
	
	public void validateHiddenText() {
		//Esperar a que cargue el elemento
		WaitForElement(hiddenText);
		// Validar que esté abajo de todo
		String hiddenTextVisibility = findElement(hiddenText).getCssValue("visibility");
		Assert.assertEquals(hiddenTextVisibility, "visible");
	}
	
	public void validateTitle() {
		String title = driver.getTitle();
		Assert.assertEquals("Lorem Ipsum Page", title);
	}
	
	public void validateSections() {
		//Validar que existan las secciones
		findElement(sectionQueEsHead);
		String expectedQueEsText ="¿Qué es Lorem Ipsum?";
		String queEsText = getText(sectionQueEsHead);
		Assert.assertEquals(expectedQueEsText, queEsText);
		
		findElement(sectionPorQueHead);
		String expectedPorQueText ="¿Por qué lo usamos?";
		String porQueText = getText(sectionPorQueHead);
		Assert.assertEquals(expectedPorQueText, porQueText);
		
		findElement(sectionDeDondeHead);
		String expectedDeDondeText ="¿De dónde viene?";
		String deDondeText = getText(sectionDeDondeHead);
		Assert.assertEquals(expectedDeDondeText, deDondeText);
		
		findElement(sectionDondePuedoHead);
		String expectedDondePuedoText ="¿Dónde puedo conseguirlo?";
		String dondePuedoText = getText(sectionDondePuedoHead);
		Assert.assertEquals(expectedDondePuedoText, dondePuedoText);
	}
	
	public void validateLinksOnSamePage() {
		
		//Esperar a que cargue el elemento
		WaitForElement(linkYoutube);
		
		//Validar targets
		String expectedTarget = "_self";
		
		String linkYoutubeTarget = findElement(linkYoutube).getAttribute("target");
		Assert.assertEquals(linkYoutubeTarget, expectedTarget);
		String linkFacebookTarget = findElement(linkFacebook).getAttribute("target");
		Assert.assertEquals(linkFacebookTarget, expectedTarget);
		String linkSeleniumTarget = findElement(linkSelenium).getAttribute("target");
		Assert.assertEquals(linkSeleniumTarget, expectedTarget);		
	}
}
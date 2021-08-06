package SeleniumTraining;

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
import org.testng.asserts.SoftAssert;

public class Ejercicio2Automation extends Base {

	By loginButton = By.id("loginBTN");
	By loremLink = By.cssSelector("a[href='/lorem/']");
	By formsLink = By.cssSelector("a[href='/forms/']");
	By homeH1 = By.id("notLoggedTitleTXT");
	By homeH3 = By.id("notLoggedScreen");
	By footer = By.className("footerClass");

	By fieldUsername = By.id("username");
	By fieldPassword = By.id("password");
	By buttonContinue = By.className("c17fd62fe");
	By wrongUserPassword = By.id("error-element-password");

	By logoutButton = By.id("logoutBTN");
	By avatarPicture = By.id("profileIMG");
	By userMessage = By.id("profileTXT");

	public Ejercicio2Automation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void validateUnloggedHome() {
		// Validar el title de la página:
		String title = driver.getTitle();
		Assert.assertEquals("Home Page", title);

		// Validar boton login existe:
		WaitForElement(loginButton);
		findElement(loginButton);

		// Validar que los links no son accesibles sin loguearse
		boolean loremLinkExiste = checkIfElementisDisplayed(loremLink);
		Assert.assertFalse(loremLinkExiste);
		boolean formsLinkExiste = checkIfElementisDisplayed(formsLink);
		Assert.assertFalse(formsLinkExiste);

		// Validar textos de la pagina
		WaitForElement(homeH1);
		String homeH1Text = getText(homeH1);
		Assert.assertEquals("Welcome to my Automation Testing Site", homeH1Text);
		WaitForElement(homeH3);
		String homeH3Text = getText(homeH3);
		Assert.assertEquals("Please click Login button to log into the application or sign up!", homeH3Text);

	}

	public void validateFooter() {
		WaitForElement(footer);

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

	public void validateInvalidLogin() {
		// Entrar al login
		WaitForElement(loginButton);
		click(loginButton);
		WaitForElement(fieldUsername);

		// Usuario y contraseña vacios
		click(fieldUsername);
		findElement(fieldUsername).clear();
		click(fieldPassword);
		findElement(fieldPassword).clear();
		click(buttonContinue);
		WaitForElement(fieldUsername);

		// Usuario vacio, contraseña invalida
		click(fieldUsername);
		findElement(fieldUsername).clear();
		click(fieldPassword);
		type("fwe4fwegr", fieldPassword);
		click(buttonContinue);
		WaitForElement(fieldUsername);

		// Usuario invalido, contraseña vacia
		click(fieldUsername);
		type("usuario invalido 1!", fieldUsername);
		click(fieldPassword);
		findElement(fieldPassword).clear();
		click(buttonContinue);
		WaitForElement(fieldUsername);

		// Mismo usuario invalido, contraseña invalida
		click(fieldPassword);
		type("Contraseña invalida!", fieldPassword);
		click(buttonContinue);
		WaitForElement(wrongUserPassword);
	}

	public void validateValidLogin() {
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
	}

	public void validateLoggedHome() {
		// Verificar que el boton logout existe
		WaitForElement(logoutButton);

		// Verificar que se muestra nuestra imagen de avatar
		checkIfElementisDisplayed(avatarPicture);

		// Verificar el mensaje para usuario "mailfalsolala"
		String expectedMessage = "Welcome mailfalsolala!";
		String actualMessage = getText(userMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
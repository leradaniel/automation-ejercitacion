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

import org.openqa.selenium.support.ui.Select; //importado

public class Ejercicio4Automation extends Base {

	// ### ACA SE DECLARAN LAS VARIABLES ### Ejemplo:
	By loginButton = By.id("loginBTN");
	By fieldUsername = By.id("username");
	By fieldPassword = By.id("password");
	By buttonContinue = By.className("c17fd62fe");
	By logoutButton = By.id("logoutBTN");
	
	By formsLink = By.cssSelector("a[href='/forms/']");
	By form = By.className("playgroundClass");

	By avatarPicture = By.id("profileIMG");
	By userMessage = By.id("profileTXT");
	By footer = By.className("footerClass");
	
	By fieldFirstName = By.id("TXTUser");
	By fieldLastName = By.id("TXTPass");
	By fieldNickname = By.id("TXTNick");
	By fieldEmail = By.id("TXTEmail");
	By fieldPersonalSite = By.id("TXTUrl");
	By fieldMobileNumber = By.id("TXTMobile");
	By fieldSomethingAbYou = By.id("TXTAbout");
	By radiusNo = By.id("RADButDevNo");
	By dropMenu = By.id("SELTitle");
	By submit = By.id("BTNSubmit");
	
	By resultFirstName = By.id("FirstName");
	By resultLastName = By.id("LastName");
	By resultNickname = By.id("NickName");
	By resultEmail = By.id("Email");
	By resultPersonalSite = By.id("Url");
	By resultMobileNumber = By.id("Mobile");
	By resultSomethingAbYou = By.id("About");
	By resultRadius = By.id("Developer");
	By resultDropMenu = By.id("Title");
	
	public Ejercicio4Automation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ### ACA SE DECLARAN LOS METODOS### Ejemplo:
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
		
		//Entrar a Forms
		click(formsLink);
		WaitForElement(form);
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
	
	public void validateTitle() {
		String title = driver.getTitle();
		Assert.assertEquals("Forms Page", title);
	}
	
	public void fillForm() {
		click(fieldFirstName);
		type("Nombrepersona",fieldFirstName);
		click(fieldLastName);
		type("Apellidopersona",fieldLastName);
		click(fieldNickname);
		type("Fulano de tal",fieldNickname);
		click(fieldEmail);
		type("mailfalsolala@gmail.com",fieldEmail);
		click(fieldPersonalSite);
		type("https://www.paginafalsa.com/",fieldPersonalSite);
		click(fieldMobileNumber);
		type("1122334455",fieldMobileNumber);
		ScrollToElement(fieldSomethingAbYou);
		click(fieldSomethingAbYou);
		type("Este es un texto de prueba para llenar un campo",fieldSomethingAbYou);
		click(radiusNo);		
		Select opciones = new Select(driver.findElement(dropMenu));
		opciones.selectByVisibleText("Miss.");
		findElement(submit);
		click(submit);
	}

	public void validateResultPage() {
		//Validar que el titulo este bien
		String title = driver.getTitle();
		Assert.assertEquals("Result Page", title);
		
		//Validar que los campos se muestren correctamente
		String Name = getText(resultFirstName);
		Assert.assertEquals(Name, "Nombrepersona");
		
		String LastName = getText(resultLastName);
		Assert.assertEquals(LastName, "Apellidopersona");

		String Nickname = getText(resultNickname);
		Assert.assertEquals(Nickname, "Fulano de tal.");
		
		String Email = getText(resultEmail);
		Assert.assertEquals(Email, "mailfalsolala@gmail.com .");
		
		String Site = getText(resultPersonalSite);
		Assert.assertEquals(Site, "https://www.paginafalsa.com/");
		
		String Mobile = getText(resultMobileNumber);
		Assert.assertEquals(Mobile, "1122334455");
		
		String About = getText(resultSomethingAbYou);
		Assert.assertEquals(About, "Este es un texto de prueba para llenar un campo");
		
		String Developer = getText(resultRadius);
		Assert.assertEquals(Developer, "no");
		
		String Title = getText(resultDropMenu);
		Assert.assertEquals(Title, "Miss");
	}
	
	public void logOut() {
		//Dsloguearse
		WaitForElement(logoutButton);
		click(logoutButton);
		
		//Boton login existe
		WaitForElement(loginButton);
		
		//Verificar que no exista el logout, avatar y mensaje de bienvenida
		boolean logoutExist = findElements(logoutButton).size() > 0;
		Assert.assertEquals(logoutExist, false);
		
		boolean avatarExist = findElements(avatarPicture).size() > 0;
		Assert.assertEquals(avatarExist, false);
		
		boolean welcomeMessageExist = findElements(userMessage).size() > 0;
		Assert.assertEquals(welcomeMessageExist, false);
	}
}
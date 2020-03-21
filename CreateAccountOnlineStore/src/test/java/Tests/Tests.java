package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


import Pages.CreateAccount;


public class Tests {
	private WebDriver driver;

	@BeforeMethod // es una anotacion par que que va pasar antes que va pasar el test

	public void setUp() {

		// la direccion de chromedriver
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");// ejecutables
		// creamos el objeto
		driver = new ChromeDriver();
		// lo maximizamos
		driver.manage().window().maximize();
		// entramos a la pagina
		driver.navigate().to("http://automationpractice.com/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


	}
	
	@Test
	public void testCreateAccount() {
	
	CreateAccount pagesCreateAccount= new CreateAccount(driver);
	pagesCreateAccount.login();
	pagesCreateAccount.createEmail("rosasp@hotmail.com");
	pagesCreateAccount.radioSexs();
	pagesCreateAccount.Date("Pepe", "Rosas","ros123");
	pagesCreateAccount.selectDay(8);
	pagesCreateAccount.selectMonth(7);
	pagesCreateAccount.selectYear("1982");
	pagesCreateAccount.DateAddress("america 123","Sun Coast",9,"00023","United States");
	pagesCreateAccount.DateAddress2("0112223","Norte 123");

	pagesCreateAccount.loginButton();
	pagesCreateAccount.AssertCreate();
	}
	

	@AfterMethod
	// para el cierre
	public void tearDown() {
		driver.close();
	}
}

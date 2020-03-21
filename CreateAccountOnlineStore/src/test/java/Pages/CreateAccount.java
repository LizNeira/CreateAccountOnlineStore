package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateAccount {
	private WebDriver driver;
	//Dropdowm List
    private By login;
    private By emailCreate;
    private By submitCreate;
    private By radioSex;
	private By titleText;
	private By customerFirstname;
	private By customerLastname;
	private By Passwd;
	private By dropDays;
	private By dropMonths;
	private By dropYears;
	private By Address1;
	private By City;
	private By dropIdState;
	private By postCode;
	private By dropIdCountry;
	private By phoneMobile;
	private By buttonSubmitAccount;
	private By Alias;
	private By list;
	public CreateAccount(WebDriver driver) {
		this.driver=driver;
		login=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
		emailCreate=By.name("email_create");
		submitCreate=By.name("SubmitCreate");
		radioSex=By.id("id_gender1");
		titleText=By.xpath("//*[@id=\"center_column\"]/p");
		customerFirstname=By.name("customer_firstname");
		customerLastname=By.name("customer_lastname");
		Passwd=By.name("passwd");
		dropDays=By.id("days");
		dropMonths=By.name("months");
		dropYears=By.id("years");
		Address1=By.name("address1");
		City=By.name("city");
		dropIdState=By.name("id_state");
		postCode=By.name("postcode");
		dropIdCountry=By.name("id_country");
		phoneMobile=By.name("phone_mobile");
		buttonSubmitAccount=By.name("submitAccount");
		Alias=By.name("alias");
	
	}
	public void login(){
	driver.findElement(login).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	public void createEmail(String email){
		driver.findElement(emailCreate).sendKeys(email);
		driver.findElement(submitCreate).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}
	public void radioSexs() {
        driver.findElement(radioSex).click();
        
}
	
	public void Date (String name,String lastN,String pass) {

		driver.findElement(customerFirstname).sendKeys(name);
		driver.findElement(customerLastname).sendKeys(lastN);
		driver.findElement(Passwd).sendKeys(pass);
 
}

	public void selectDay(int day) {
	
		//WebElement dropDay=driver.findElement(driver.findElement(by)dropDays);

		Select selectDropDay =new Select(driver.findElement(dropDays));
		selectDropDay.selectByIndex(day);
		
	} 
	public void selectMonth(int month) {
		Select selectDropMonth=new Select(driver.findElement(dropMonths));
		selectDropMonth.selectByIndex(month);

		
	}
	public void  selectYear(String year) {

		Select selectDropYear = new Select(driver.findElement(dropYears));
		selectDropYear.selectByValue(year);;
	}
	
	
	public void DateAddress(String address,String city,int idState,String code,String idCountry) {
		
		driver.findElement(Address1).sendKeys(address); 
		driver.findElement(City).sendKeys(city);//9 florida
		
		Select selectDropState=new Select(driver.findElement(dropIdState));
		selectDropState.selectByIndex(9);
		
		driver.findElement(postCode).sendKeys(code);
		
		Select selectDropCountry=new Select(driver.findElement(dropIdCountry));
		selectDropCountry.selectByVisibleText(idCountry);
		

	}
 
 public void DateAddress2(String mobile,String addAlias) {
	 
	driver.findElement(phoneMobile).sendKeys(mobile);
		
	driver.findElement(Alias).sendKeys(addAlias); 
 }
 public void loginButton() {
		driver.findElement(buttonSubmitAccount).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


 }
 public void AssertCreate() {

		// los maneja testng
		// para que le test pase
		// lo que esta aca adentro tiene que devolver verdadero
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Welcome to your account. Here you can manage all of your personal information and orders."));
		   System.out.println("1.approved test");
	}
//selectDropBirthdayMonth.selectByValue("8");
		//selectDropBirthdayMonth.selectByVisibleText(month);
 
}

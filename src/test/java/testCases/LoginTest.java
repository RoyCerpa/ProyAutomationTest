package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.Base;
import configuration.TestData;
import pages.LoginPage;

 //public static void main(String[] args)
    
        public class LoginTest extends Base {

	private static Logger Log = LogManager.getLogger(LoginTest.class.getName
        ());
	private static TestData d= new TestData();

	@BeforeTest
	public void conectarseConsensus() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}     
        
        @Test
	public void loginCredencialesCorrectasTest() throws IOException, InterruptedException {

		ArrayList<String> data = d.getData("LoginTest","loginCredencialesCorrectasTest");
		 Log.debug("Credenciales obtenidas del excel de data");

		String username = data.get(2);
		String password = data.get(3);
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);		
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.setUsername(username); login.setPassword(password);
		Log.debug("Credenciales completadas");
                
		login.submitLogin();
		Log.debug("Clic en botón Login");
                Thread.sleep(2000);
				
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'logo_cliente\']/img")));
                
		String tituloObtenido= driver.getTitle();
		String tituloEsperado= "CONSENSUS";		
                
                Assert.assertTrue(tituloObtenido.contains(tituloEsperado));
		Log.info("Inicio de sesión correcto");
                driver.manage().window().maximize();
                
                
                //driver.findElement(By.xpath("//*[@id=\'page-wrapper\']/xdf-topnavbar/div/nav/ul/li[1]/a")).click();
                
               // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);		
              //  driver.findElement(By.xpath("//*[@id=\'side-menu\']/li[5]/a/span[1]")).click();
		
	        /*driver.findElement(By.xpath("//*[@id=\'page-wrapper\']/xdf-topnavbar/div/nav/ul/li[3]/a")).click();
		Log.debug("Cerrando sesión");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
		
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'l-login\']/button")));
                driver.navigate().back();
                Log.debug("Cargando página de nuevo");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'l-login\']/button")));		
              */  
	}
	


	@Test
	public void loginUsernameIncorrectoTest() throws IOException, InterruptedException {
		
		ArrayList<String> data = d.getData("LoginTest","loginUsernameIncorrectoTest");

		Log.debug("Credenciales obtenidas del excel de data");

		String username = data.get(2);
		String password = data.get(3);
		System.out.println("Username Incorrecto");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
		
		String UrlInicioObtenidaInicio= driver.getCurrentUrl(); 
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.setUsername(username); 
                login.setPassword(password);
		Log.debug("Credenciales completadas");
		login.submitLogin();
		Log.debug("Clic en botón Login");
                Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
		
		String UrlInicioObtenidaFinal= driver.getCurrentUrl(); 
                                	
		Assert.assertNotEquals(UrlInicioObtenidaInicio, UrlInicioObtenidaFinal);

		Log.info("Inicio de sesión fallido - Username Incorrecto");
		
                driver.navigate().back();
                Log.debug("Cargando página de nuevo");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'l-login\']/button")));		

	}

	@Test
	public void loginPasswordIncorrectoTest() throws IOException, InterruptedException {
		
		ArrayList<String> data = d.getData("LoginTest","loginPasswordIncorrectoTest");

		Log.debug("Credenciales obtenidas del excel de data");

		String username = data.get(2);
		String password = data.get(3);
		System.out.println("Username Incorrecto");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
		
		String UrlInicioObtenidaInicio= driver.getCurrentUrl(); 
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.setUsername(username); login.setPassword(password);
		Log.debug("Credenciales completadas");
		login.submitLogin();
		Log.debug("Clic en botón Login");
                Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
		
		String UrlInicioObtenidaFinal= driver.getCurrentUrl(); 
		
		Assert.assertNotEquals(UrlInicioObtenidaInicio, UrlInicioObtenidaFinal);

		Log.info("Inicio de sesión fallido - Password Incorrecto");
		
		//driver.navigate().refresh();
                driver.navigate().back();
                Log.debug("Cargando página de nuevo");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'l-login\']/button")));

	}
        

	@AfterTest
	public void cerrarNavegador() throws IOException {
		driver.close();
		driver=null;
	}

}

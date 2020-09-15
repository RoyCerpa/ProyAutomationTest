package testCases;

import configuration.Base;
import static configuration.Base.driver;
import configuration.TestData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MantenimientoDocSoporteCreatePage;
import pages.MantenimientoDocSoportePrincipalPage;

import pages.MenuPrincipalPage;

public class MantenimientoDocSoporteTest extends Base{
        private static Logger Log = LogManager.getLogger(MantenimientoDocSoporteTest.class.getName());
	private static TestData d= new TestData();
	
	@BeforeTest
        //@Test
	public void conectarseConsensus() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
                
		LoginTest logPrueba= new LoginTest();
                
		logPrueba.loginCredencialesCorrectasTest();
                
                WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-wrapper']/xdf-topnavbar/div/nav/ul/li[1]/a")));		
                
               MenuPrincipalPage menu= PageFactory.initElements(driver, MenuPrincipalPage.class);
               menu.clicPerfil();
               Thread.sleep(2000);
               driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
               menu.clicEleccionPerfil();
                
               wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'side-menu\']/li[4]/a/span[1]")));		
               Thread.sleep(2000);
                
               menu.clicMantenimientoDocumentoSoporte();
               
               Thread.sleep(2000);

	}
     
   
        
        
        
       @Test(priority=1)
        public void MantenimientodDocSoporteCrearDocumentoCorrecto() throws IOException, InterruptedException {
            
            ArrayList<String> data = d.getData("MantenimientodDocSoporteTest","MantenimientodDocSoporteCrearDocumentoCorrecto");

            Log.debug("Datos obtenidos del excel de data");

            String Abreviatura = data.get(2);
            String Nombre = data.get(3);
            String Description = data.get(4);
            String Tipo = data.get(5);
            String EquivComercial = data.get(6);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    
            wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
            
            MantenimientoDocSoportePrincipalPage mantenimientoDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoportePrincipalPage.class);
            mantenimientoDocSoporte.clicNuevoDocumentoSoporte();
            
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            Log.debug("Clic en Nuevo Documento de Soporte");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab-1']/div/div[1]/div[1]/h2")));
            
            MantenimientoDocSoporteCreatePage crearDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoporteCreatePage.class);
            crearDocSoporte.setAbreviaturaDocumento(Abreviatura);
            Log.debug("Se ingresa Abreviatura");
            
            crearDocSoporte.setNombreDocumento(Nombre);
            Log.debug("Se ingresa Nombre de Documento");
            
            crearDocSoporte.setDescripcionDocumento(Description);
            Log.debug("Se ingresa descripción del Documento");
            
            crearDocSoporte.selectionOptionAbono();
            Log.debug("Se ingresa tipo opcion abono");

            crearDocSoporte.setEquivComercial();
            Log.debug("Se ingresa seccion Equiv Comercial");
            
            crearDocSoporte.setSistemaOrigenSAP(EquivComercial);
            Log.debug("Se ingresa valor de Sistema Origen");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab-2']/div/div[2]/div/div/div/button")));
            Thread.sleep(2000);

            mantenimientoDocSoporte.clicbotonGuardarDocumento();
            Log.debug("Clic en Guardar");
            Thread.sleep(2000);                       

            wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
           

            Boolean existeDocumento= mantenimientoDocSoporte.existeDocumento(Abreviatura,Nombre);
            Assert.assertTrue(existeDocumento);
            Log.info("Documento Creado Correctamente");
          
        }
        
        @Test (priority=2)
        public void FiltroporCodigoCorrecto() throws IOException, InterruptedException {
            

            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
            
            MantenimientoDocSoportePrincipalPage mantenimientoDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoportePrincipalPage.class);
                        
            String Codigoretornado = mantenimientoDocSoporte.retornoCodigo();
            
            mantenimientoDocSoporte.clicOpcionFiltro();
            Log.debug("Clic en opcion de Filtro");
            
            Actions a= new Actions(driver);
            a.sendKeys(Codigoretornado + Keys.ENTER).build().perform();
            Log.debug("Seteo de codigo nombre");
            Thread.sleep(2000);
            
            
            mantenimientoDocSoporte.clicBuscar();
            Log.debug("Busqueda por Nombre");
            
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            int Filtro= mantenimientoDocSoporte.retornofiltroBusqueda();
            Assert.assertTrue(Filtro==1);         
            
            mantenimientoDocSoporte.ClickBotonEditar();
        }
        
        @Test (priority=3)
        public void MantenimientodDocSoporteEditarDocumentoCorrecto() throws IOException, InterruptedException {
            
            ArrayList<String> data = d.getData("MantenimientodDocSoporteTest","MantenimientodDocSoporteEditarDocumentoCorrecto");

            Log.debug("Datos obtenidos del excel de data");

          //String Abreviatura = data.get(2);
            String Nombre = data.get(3);
            String Description = data.get(4);
            String Tipo = data.get(5);
            String EquivComercial = data.get(6);
            
            WebDriverWait wait = new WebDriverWait(driver,10);

            wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
            
            MantenimientoDocSoportePrincipalPage mantenimientoDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoportePrincipalPage.class);
                        
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            Log.debug("Clic en Nuevo Documento de Soporte");
            
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab-1']/div/div[1]/div[1]/h2")));
            Thread.sleep(2000);
            
            MantenimientoDocSoporteCreatePage crearDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoporteCreatePage.class);
            
            crearDocSoporte.setNombreDocumentoEdit(Nombre);
            Log.debug("Se edita Nombre de Documento");
            Thread.sleep(1000);
            
            crearDocSoporte.setDescripcionDocumentoEdit(Description);
            Log.debug("Se edita descripción del Documento");
            
            crearDocSoporte.selectionOptionCargoEdit();
            Log.debug("Se edita tipo opcion Cargo");

            crearDocSoporte.setEquivComercial();
            Log.debug("Se edita seccion Equiv Comercial");
            
            crearDocSoporte.setSistemaOrigenSAP(EquivComercial);
            Log.debug("Se edita valor de Sistema Origen");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab-2']/div/div[2]/div/div/div/button")));
            Thread.sleep(2000);

            mantenimientoDocSoporte.clicbotonGuardarDocumento();
            Log.debug("Clic en Guardar");
            Thread.sleep(2000);                       

            wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
           
            Boolean existeDocumento= mantenimientoDocSoporte.existePerfilEdit(Nombre);
            Assert.assertTrue(existeDocumento);
            Log.info("Documento Soporte editado Correctamente");
                            
        }
        
        @Test(priority=4)	
        public void MantenimientodDocSoporteEliminarCorrecto() throws IOException, InterruptedException {
            
            ArrayList<String> data = d.getData("MantenimientodDocSoporteTest","MantenimientodDocSoporteEliminarCorrecto");

            Log.debug("Datos obtenidos del excel de data");

            String Abreviatura = data.get(2);
            String Nombre = data.get(3);


            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Documentos Soporte"));
      
            MantenimientoDocSoportePrincipalPage mantenimientoDocSoporte= PageFactory.initElements(driver, MantenimientoDocSoportePrincipalPage.class);
                      
            mantenimientoDocSoporte.clicOpcionFiltro();
            Log.debug("Clic en opcion de Filtro");
            
            Actions a= new Actions(driver);
            a.sendKeys(Abreviatura + Keys.ENTER).build().perform();
            Log.debug("Filtro por codigo para proceder con la eliminacion");
            Thread.sleep(2000);            

            mantenimientoDocSoporte.clicBuscar();
            Log.debug("Busqueda por Codigo o Abreviatura");
            
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            mantenimientoDocSoporte.ClickBotonEliminar();
            Log.debug("Clic en opcion de de eliminar");
             
            mantenimientoDocSoporte.ClickEliminacionConfirmada();
            Thread.sleep(2000);
            mantenimientoDocSoporte.ClickDesactivarFiltro();
            
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            Boolean existeDocumento= mantenimientoDocSoporte.existeDocumento(Abreviatura,Nombre);
            Assert.assertFalse(existeDocumento);
            Log.info("Documento Soporte Fue Eliminado Exitosamente");
                                  
        }
        
        // @AfterTest
	public void cerrarNavegador() throws IOException {
		driver.close();
                driver=null;
	}

}



       /*
        //@Test
        public void mantenimientoStagesCrearIdentificadorInvalido() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesCrearIdentificadorInvalido");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String passwordStage = data.get(3);
            String descriptionStage = data.get(4);
            String typeStage = data.get(5);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.clicNuevo();
            Log.debug("Clic en Nuevo");
            wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "Información General"));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(nameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setContraseñaStage(passwordStage);
            Log.debug("Se ingresa contraseña de Stage");
            crearStages.setDescripcionStage(descriptionStage);
            Log.debug("Se ingresa descripción de Stage");
            crearStages.setTipoStage(typeStage);
            Log.debug("Se ingresa tipo de Stage");
                       
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                         
            Assert.assertEquals("Información General", driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText());
            Log.info("No se creó el Stage por indentificador invalido");

            driver.navigate().back();
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
                       
        }
        
       // @Test
        public void mantenimientoStagesCrearContraseñaInvalida() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesCrearContraseñaInvalida");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String passwordStage = data.get(3);
            String descriptionStage = data.get(4);
            String typeStage = data.get(5);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.clicNuevo();
            Log.debug("Clic en Nuevo");
            wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "Información General"));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(nameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setContraseñaStage(passwordStage);
            Log.debug("Se ingresa contraseña de Stage");
            crearStages.setDescripcionStage(descriptionStage);
            Log.debug("Se ingresa descripción de Stage");
            crearStages.setTipoStage(typeStage);
            Log.debug("Se ingresa tipo de Stage");
                        
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                          
            Assert.assertEquals("Información General", driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText());
            Log.info("No se creó el Stage por contraseña invalida");
            
            driver.navigate().back();
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
                       
        }
        
       // @Test
        public void mantenimientoStagesCrearDescripcionInvalida() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesCrearDescripcionInvalida");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String passwordStage = data.get(3);
            String descriptionStage = data.get(4);
            String typeStage = data.get(5);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.clicNuevo();
            Log.debug("Clic en Nuevo");
            wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "Información General"));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(nameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setContraseñaStage(passwordStage);
            Log.debug("Se ingresa contraseña de Stage");
            crearStages.setDescripcionStage(descriptionStage);
            Log.debug("Se ingresa descripción de Stage");
            crearStages.setTipoStage(typeStage);
            Log.debug("Se ingresa tipo de Stage");
                        
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                          
            Assert.assertEquals("Información General", driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText());
            Log.info("No se creó el Stage por descripcion invalida");
            
            driver.navigate().back();
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
                       
        }
        
      //  @Test
        public void mantenimientoStagesCrearTipoInvalido() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesCrearTipoInvalido");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String passwordStage = data.get(3);
            String descriptionStage = data.get(4);
            String typeStage = data.get(5);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.clicNuevo();
            Log.debug("Clic en Nuevo");
            wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "Información General"));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(nameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setContraseñaStage(passwordStage);
            Log.debug("Se ingresa contraseña de Stage");
            crearStages.setDescripcionStage(descriptionStage);
            Log.debug("Se ingresa descripción de Stage");
            crearStages.setTipoStage(typeStage);
            Log.debug("Se ingresa tipo de Stage");
                        
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                          
            Assert.assertEquals("Información General", driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText());
            Log.info("No se creó el Stage por tipo invalido");
            
            driver.navigate().back();
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
                       
        }
        /*
        @Test
        public void mantenimientoStagesEditarInvalido() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesEditarInvalido");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String passwordStage = data.get(3);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.accionStage(nameStage, "Editar");
            Log.debug("Clic en Editar");
            wait.until(ExpectedConditions.textToBe(By.id("nombre"), nameStage));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(nameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setContraseñaStage(passwordStage);
            Log.debug("Se ingresa contraseña de Stage");
                       
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                       
            Assert.assertEquals("Información General", driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText());
            Log.info("No se editó el Stage por contraseña invalida");
            
            driver.navigate().back();
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
                            
        }
        /*
     //   @Test
        public void mantenimientoStagesEditarCorrecto() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesEditarCorrecto");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            String descriptionStage = data.get(3);
            String typeStage = data.get(4);
            String newNameStage = data.get(5);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            mantenimientoStages.accionStage(nameStage, "Editar");
            Log.debug("Clic en Editar");
            wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), "Información General"));
            
            MantenimientoStagesCreatePage crearStages= PageFactory.initElements(driver, MantenimientoStagesCreatePage.class);
            crearStages.setNombreStage(newNameStage);
            Log.debug("Se ingresa nombre de Stage");
            crearStages.setDescripcionStage(descriptionStage);
            Log.debug("Se ingresa descripción de Stage");
            crearStages.setTipoStage(typeStage);
            Log.debug("Se ingresa tipo de Stage");
                       
            crearStages.clicGuardar();
            Log.debug("Clic en Guardar");
                       
            wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            mantenimientoStages.clicUltimo();
            
            Boolean existeStage= mantenimientoStages.existeStage(newNameStage, descriptionStage, typeStage);
            Assert.assertTrue(existeStage);
            Log.info("Stage editado Correctamente");
                            
        }
*/

        /*          
        @Test
        public void mantenimientoStagesEliminarCancelado() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesEliminarCancelado");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
                       
            driver.manage().deleteAllCookies();
            
            mantenimientoStages.accionStage(nameStage, "Eliminar");
            Log.debug("Clic en Eliminar");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            
            driver.findElement(By.xpath("//button[@data-bb-handler='cancel']")).click();
            Log.debug("Clic en Cancelar");
            
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
                                           
        }
        
         @Test
        public void mantenimientoStagesEliminarCorrecto() throws IOException {
            
            ArrayList<String> data = d.getData("MantenimientoStagesTest","mantenimientoStagesEliminarCorrecto");

            Log.debug("Datos obtenidos del excel de data");

            String nameStage = data.get(2);
            
            WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.textToBe(By.tagName("h5"), "Mantenimiento de Stages"));
            MantenimientoStagesPrincipalPage mantenimientoStages= PageFactory.initElements(driver, MantenimientoStagesPrincipalPage.class);
            
            driver.manage().deleteAllCookies();
                       
            mantenimientoStages.accionStage(nameStage, "Eliminar");
            Log.debug("Clic en Eliminar");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            
            driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
            Log.debug("Clic en Aceptar");
            
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
                        
            Log.info("Stage eliminado Correctamente");
                       
        }*/
    
         // */
       
        




// ANEXOS METODO BOLEAN

         //   WebElement table= driver.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']"));
          //  int pos = table.findElements(By.tagName("tr")).size()-1;
            //.findElements(By.tagName("tr")).size();
            
         //   Log.info("Documento Creado Correctamente TABLA "+pos);
            
     //   String CodigoAbrvv2= table.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[1]")).getText();
        // System.out.println(CodigoAbrvv2);
       //  Log.info("Documento Creado CorrectamenteCODIGO"+CodigoAbrvv2);
     //   String NombreDocv2= table.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[2]")).getText();
       // System.out.println(NombreDocv2);
      //  Log.info("Documento Creado Correctamente NOMBRE"+NombreDocv2);
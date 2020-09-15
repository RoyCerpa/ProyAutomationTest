
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPrincipalPage {
    
    @FindBy(how = How.XPATH, using = "//*[@id=\'page-wrapper\']/xdf-topnavbar/div/nav/ul/li[1]/a")
    @CacheLookup
    private WebElement PerfilOpcion;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\'side-menu\']/li[5]/a/span[1]")
    @CacheLookup
    private WebElement configuracionOpcion;    
    

    public void clicPerfil (){

        PerfilOpcion.click();  

    }    
    
      public void clicEleccionPerfil (){    

        PerfilOpcion.findElement(By.xpath("//*[@id='tab-roles']/div[3]/div/div/div[2]/a")).click(); 
        PerfilOpcion.click();    
    }    
    
    public void clicMantenimientoDocumentoSoporte (){    
        configuracionOpcion.click();
        configuracionOpcion.findElement(By.xpath("//*[@id=\'side-menu\']/li[5]/ul/li[3]/a")).click();      
    }    

}


    
    /*
    public void clicMantenimientoAgentes (){    
        agentesOpcion.findElement(By.tagName("a")).click();
        agentesOpcion.findElement(By.xpath("//a[contains(text(),'Agentes')]")).click();      
    }  
    
    public void clicMantenimientoPerfilesAtencion (){    
        agentesOpcion.findElement(By.tagName("a")).click();
        agentesOpcion.findElement(By.xpath("//a[contains(text(),'Perfiles de Atención')]")).click();      
    }  
    
    public void clicGestorEntidades (){    
        entidadOpcion.findElement(By.tagName("a")).click();
        entidadOpcion.findElement(By.xpath("//a[contains(text(),'Gestor de entidades')]")).click();      
    }  
    
    
    -----
    
        @FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[5]")
    @CacheLookup
    private WebElement sistemaOpcion;    
    
    @FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[6]")
    @CacheLookup
    private WebElement seguridadOpcion;    
    
    
    
   */     
    /*
    public void clicMantenimientoAgentes (){    
        agentesOpcion.findElement(By.tagName("a")).click();
        agentesOpcion.findElement(By.xpath("//a[contains(text(),'Agentes')]")).click();      
    }  
    
    public void clicMantenimientoPerfilesAtencion (){    
        agentesOpcion.findElement(By.tagName("a")).click();
        agentesOpcion.findElement(By.xpath("//a[contains(text(),'Perfiles de Atención')]")).click();      
    }  
    
    public void clicGestorEntidades (){    
        entidadOpcion.findElement(By.tagName("a")).click();
        entidadOpcion.findElement(By.xpath("//a[contains(text(),'Gestor de entidades')]")).click();      
    }  
    
    
    -----
    
        @FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[5]")
    @CacheLookup
    private WebElement sistemaOpcion;    
    
    @FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[6]")
    @CacheLookup
    private WebElement seguridadOpcion;    
    
    
    
   */ 



         //driver.findElement(By.xpath("//*[@id=\'page-wrapper\']/xdf-topnavbar/div/nav/ul/li[1]/a")).click();
         
              // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);		
              //  driver.findElement(By.xpath("//*[@id=\'side-menu\']/li[5]/a/span[1]")).click();






        //PerfilOpcion.findElement(By.xpath("//a[contains(text(),'Adm')]")).click(); 
       // PerfilOpcion.findElement(By.xpath("//a[contains(text(),'Adm')]")).click(); 
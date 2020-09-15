package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class MantenimientoDocSoporteCreatePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-1\"]")
    @CacheLookup
    private WebElement Abreviatura;

    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-0\"]")
    @CacheLookup
    private WebElement Nombre;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    private WebElement Descripcion;
    
    @FindBy(how = How.CSS, using = "#mat-radio-3")
    @CacheLookup
    private WebElement OptionCargo;

    @FindBy(how = How.CSS, using = "#mat-radio-2")
    @CacheLookup
    private WebElement OptionAbono;
    
   
    @FindBy(how = How.XPATH, using ="//*[@id=\"page-wrapper\"]/div/byte-support-documents-detail/div/div/div/div/div/ul/li[2]/a")
    @CacheLookup                     
    private WebElement EquivComercial;

    @FindBy(how = How.XPATH, using = "//*[@id='tab-2']/div/div[1]/div[2]/div/div/div/table/tbody/tr[2]/td[2]/div/input")
    @CacheLookup 
    private WebElement sistemaOrigenSAP;


    
    public void setAbreviaturaDocumento(String Abrv) {
        Abreviatura.clear();
        Abreviatura.sendKeys(Abrv);
    }

    public void setNombreDocumento(String nombre) {
        Nombre.clear();
        Nombre.sendKeys(nombre);
    }

    public void setDescripcionDocumento(String Desc) {
        Descripcion.clear();
        Descripcion.sendKeys(Desc);
    }

    public void selectionOptionCargo() {
        OptionCargo.click();
    }
    
    public void selectionOptionAbono() {
        OptionAbono.click();
    }

    public void setEquivComercial() {
        EquivComercial.click();
    }
    
    public void setSistemaOrigenSAP(String SistOrigen) {
        sistemaOrigenSAP.clear();
        sistemaOrigenSAP.sendKeys(SistOrigen);
    }
    
    public void selectionOptionCargoEdit() {
        
    OptionCargoMod.click();
    }
    
   
    @FindBy(how = How.CSS, using = "#mat-radio-6")
  //@FindBy(how = How.CSS, using = "#mat-radio-3")
    @CacheLookup
    private WebElement OptionCargoMod;

    
    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-3\"]")
    //@FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-0\"]")
    @CacheLookup
    private WebElement Nombremod;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-5\"]")
  //@FindBy(how = How.XPATH, using = "//*[@id=\"mat-input-2\"]")
 
    @CacheLookup
    private WebElement Descripcionmod;
    

     public void setNombreDocumentoEdit(String nombre) {
        Nombremod.clear();
        Nombremod.sendKeys(nombre);
    }

    public void setDescripcionDocumentoEdit(String Descmod) {
        Descripcionmod.clear();
        Descripcionmod.sendKeys(Descmod);
    }   
}



/*
    public void setActiveCheckVencimiento(String Check) {
              
       if(Check.equalsIgnoreCase("TRUE")){
       checkVencimiento.click();
       }      
    }


    public void setActiveTipoAgentePerfil(String type) {
        
        if(type.equalsIgnoreCase("Grupos de Responsables")){
        radioGruoposResponsables.click();
        }else
        {
        //radioResponsables.click();
        }
        
        

    }
    
    public void setResponsable(String responsable) {

        reponsables_chosencontainers.click();
        int numOptions = reponsables_chosencontainers.findElements(By.xpath("//div/ul/li")).size();
        int value = 0;

        for (int i = 0; i < numOptions; i++) {
            String option = reponsables_chosencontainers.findElements(By.xpath("//div/ul/li")).get(i).getText();
            if (option.equalsIgnoreCase(responsable)) {
                value = 1;
            }
        }

        if (value == 1) {
            reponsables_chosencontainers.findElement(By.xpath("//div[@class='chosen-search']/input[@type='text']")).sendKeys(responsable + Keys.ENTER);
        } else {
            reponsables_chosencontainers.findElement(By.xpath("//div[@class='chosen-search']/input[@type='text']")).sendKeys(Keys.ENTER);
        }

    }


    public void setGrupoResponsable(String gruporesponsable) {

        gruposReponsables_chosencontainers.click();
        int numOptions = gruposReponsables_chosencontainers.findElements(By.xpath("//div/ul/li")).size();
        int value = 0;

        for (int i = 0; i < numOptions; i++) {
            String option = gruposReponsables_chosencontainers.findElements(By.xpath("//div/ul/li")).get(i).getText();
            if (option.equalsIgnoreCase(gruporesponsable)) {
                value = 1;
            }
        }

        if (value == 1) {
            gruposReponsables_chosencontainers.findElement(By.xpath("//div[@class='chosen-search']/input[@type='text']")).sendKeys(gruporesponsable + Keys.ENTER);
        } else {
            gruposReponsables_chosencontainers.findElement(By.xpath("//div[@class='chosen-search']/input[@type='text']")).sendKeys(Keys.ENTER);
        }

    }

    public void setTiempoAtencionPerfilAgente(String tmax) {
        TiempoAtencionAgente.clear();
        TiempoAtencionAgente.sendKeys(tmax);
    }

    public void selectionUnidadTimeAgente(String UnTiempo) {
        
        UnidadTiempoAgente.click();
        Select Option = new Select(UnidadTiempoAgente);
        Option.selectByVisibleText(UnTiempo);
    }
    
    ------
    
        //@FindBy(how = How.ID, using = "radioResponsables")
    //@CacheLookup
    //private WebElement radioResponsables;
    
    @FindBy(how = How.XPATH, using = "//input[@id='radioResponsables']")
    @CacheLookup
    private WebElement radioResponsables;
       

    @FindBy(how = How.XPATH, using = "//input[@id='radioGruposResponsables']")
    @CacheLookup
    private WebElement radioGruoposResponsables;
  
    @FindBy(how = How.XPATH, using = "//*[@id='responsables_chosen']")
    @CacheLookup
    private WebElement reponsables_chosencontainers;
    
    
    @FindBy(how = How.XPATH, using = "//*[@id='gruposResponsables_chosen']")
    @CacheLookup
    private WebElement gruposReponsables_chosencontainers;
    
   

    @FindBy(how = How.ID, using = "tiempoAtencion")
    @CacheLookup
    private WebElement TiempoAtencionAgente;

    @FindBy(how = How.ID, using = "unidadTiempo")
    @CacheLookup
    private WebElement UnidadTiempoAgente;    //@FindBy(how = How.ID, using = "radioResponsables")
    //@CacheLookup
    //private WebElement radioResponsables;
    
    @FindBy(how = How.XPATH, using = "//input[@id='radioResponsables']")
    @CacheLookup
    private WebElement radioResponsables;
       

    @FindBy(how = How.XPATH, using = "//input[@id='radioGruposResponsables']")
    @CacheLookup
    private WebElement radioGruoposResponsables;
  
    @FindBy(how = How.XPATH, using = "//*[@id='responsables_chosen']")
    @CacheLookup
    private WebElement reponsables_chosencontainers;
    
    
    @FindBy(how = How.XPATH, using = "//*[@id='gruposResponsables_chosen']")
    @CacheLookup
    private WebElement gruposReponsables_chosencontainers;
    
   

    @FindBy(how = How.ID, using = "tiempoAtencion")
    @CacheLookup
    private WebElement TiempoAtencionAgente;

    @FindBy(how = How.ID, using = "unidadTiempo")
    @CacheLookup
    private WebElement UnidadTiempoAgente;
    
    
*/
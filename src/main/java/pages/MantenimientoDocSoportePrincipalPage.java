
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MantenimientoDocSoportePrincipalPage {

    @FindBy( how = How.XPATH ,  using = "//*[@id='page-wrapper']/div/byte-support-documents/div/div/div/div/div[2]/div/div[2]/button")
                                     
    private WebElement botonNuevo;
        
    @FindBy( how = How.XPATH ,  using = "//*[@id='page-wrapper']/div/byte-support-documents-detail/div/div/div/div/div/ul/li[2]/a")
    private WebElement SeccionEquivComercial;
    
    @FindBy( how = How.XPATH ,  using = "//*[@id='tab-2']/div/div[2]/div/div/div/button")
    private WebElement botonGuardar;
    
    @FindBy( how = How.XPATH ,  using = "//*[@id=\"page-wrapper\"]/div/byte-support-documents/div/div/div/div/div[2]/div/div[1]/div[1]/xdf-ngx-tags-input/div/input[1]")
    private WebElement OpcionFiltro;     
    
    @FindBy( how = How.XPATH ,  using = "//*[@id=\"mat-option-8\"]/span/span")
    private WebElement FiltroByCodigo;
     
    @FindBy( how = How.XPATH ,  using = "//*[@id=\"mat-option-9\"]/span/span")
    private WebElement FiltroByNombre;
    
    @FindBy( how = How.XPATH ,  using = "(//button[@class=\"btn btn-default btn-sm\"])[2]")
    private WebElement BtnEliminar;
        
    @FindBy( how = How.XPATH ,  using = "//*[@id=\"page-wrapper\"]/div/byte-support-documents/div/div/div/div/div[2]/div/div[1]/div[1]/xdf-ngx-tags-input/div/button[1]")
    private WebElement OpcionBuscar;
        
    @FindBy( how = How.XPATH ,  using = "//table[@class='crud-table table table-striped table-hover mat-table']")
    private WebElement listaDocumentos;
    
    
    @FindBy( how = How.XPATH ,  using = "//button[@class=\"btn btn-default btn-sm\"]")
    private WebElement BtnEditar; 
    
    @FindBy( how = How.XPATH ,  using = "(//button[@class=\"mat-button mat-button-base\"])[2]")
    private WebElement BtnConfirmaEliminacion;

    @FindBy( how = How.XPATH ,  using = "//button[@class=\"btn btn-default btn-options\"]")
    private WebElement BtnDesactivarFiltro;
    
 
    public void clicNuevoDocumentoSoporte(){   
        botonNuevo.click();      
    }
    
    public void clicSeccionEquivComercial(){   
        SeccionEquivComercial.click();      
    }
    
    public void clicbotonGuardarDocumento(){   
        botonGuardar.click();      
    }
    
     public void clicOpcionFiltro(){   
        OpcionFiltro.click();      
    }
     
    
    public void clicFiltroByCode(){   
        FiltroByCodigo.click();      
    }
    
    public void clicFiltroByNombre(){   
        FiltroByNombre.click();      
    }
    
    public void clicBuscar(){   
        OpcionBuscar.click();      
    }
    
    public void setFiltroBasico(String Filtro) {
        OpcionFiltro.clear();
        OpcionFiltro.sendKeys(Filtro);
        
    }
    
    public void ClickDesactivarFiltro() {
    BtnDesactivarFiltro.click();
        
    }
    
    public void ClickBotonEditar() {
    BtnEditar.click();
           
    }
    public void ClickBotonEliminar() {
    BtnEliminar.click();
           
    }
    
    public void ClickEliminacionConfirmada() {
    BtnConfirmaEliminacion.click();
           
    }
    
   /*  public void clicaAceptedNuevaAtencionPerfil(){   
        aceptar.click();      
    }
    
      public void clicaSaveNuevoAtencionPerfil(){   
        grabar.click();      
    }
   
      */
     public boolean existeDocumento(String abrv, String NomDoc){
        
        int pos= listaDocumentos.findElements(By.tagName("tr")).size()-1;

        String CodigoAbrv= listaDocumentos.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[1]")).getText();
         //System.out.println(CodigoAbrv);                       //table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr[3]/td[1]
        String NombreDoc= listaDocumentos.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[2]")).getText();
       // System.out.println(NombreDoc);
        //String tipo= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[4]")).getText();
        
        //if(CodigoAbrv.equalsIgnoreCase(abrv) && NombreDoc.contains(NomDoc)){
        if(CodigoAbrv.equalsIgnoreCase(abrv) && NombreDoc.contains(NomDoc)){
            return true;
        }else{
            return false;
        }
        
    }
         public String retornoCodigo(){
        
        int pos= listaDocumentos.findElements(By.tagName("tr")).size() - 1;

         String CodigoAbrv= listaDocumentos.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[1]")).getText();
        // System.out.println(CodigoAbrv);
        //String NombreDoc= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[2]")).getText();
        //System.out.println(NombreDoc);
        //String tipo= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[4]")).getText();

            return CodigoAbrv;
        }
         
        public String retornoNombre(){
        
        int pos= listaDocumentos.findElements(By.tagName("tr")).size() - 1;

        //String CodigoAbrv= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[1]")).getText();
        // System.out.println(CodigoAbrv);
        String NombreDoc= listaDocumentos.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[2]")).getText();
        System.out.println(NombreDoc);
        //String tipo= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[4]")).getText();

            return NombreDoc;
        }
        
        public int retornofiltroBusqueda(){
        
        int FiltroAplicado= listaDocumentos.findElements(By.tagName("tr")).size() - 1;

            return FiltroAplicado;
        }
        
        public boolean existePerfilEdit(String NomDoc){
        
        int pos= listaDocumentos.findElements(By.tagName("tr")).size()-1;

        //String CodigoAbrv= listaPerfiles.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[1]")).getText();
         //System.out.println(CodigoAbrv);                       //table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr[3]/td[1]
        String NombreDoc= listaDocumentos.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']/tbody/tr["+pos+"]/td[2]")).getText();
       // System.out.println(NombreDoc);
        //String tipo= listaPerfiles.findElement(By.xpath("//tr["+pos+"]/td[4]")).getText();
        
        //if(CodigoAbrv.equalsIgnoreCase(abrv) && NombreDoc.contains(NomDoc)){
        if(NombreDoc.contains(NomDoc)){
            return true;
        }else{
            return false;
        }
        
    }
        
        
        
  }
          //  WebElement table= driver.findElement(By.xpath("//table[@class='crud-table table table-striped table-hover mat-table']"));
          //  int pos = table.findElements(By.tagName("tr")).size()-1;
            //.findElements(By.tagName("tr")).size();
            
          //  Log.info("Documento Creado Correctamente TABLA "+pos);
            
           

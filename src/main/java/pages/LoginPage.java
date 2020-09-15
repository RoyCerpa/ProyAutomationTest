package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.NAME, using = "username")
    @CacheLookup
    private WebElement username;
    
    @FindBy(how = How.NAME, using = "password")
    @CacheLookup
    private WebElement password;
    // 
    @FindBy(how = How.XPATH, using = "//*[@id='l-login']/button")
    @CacheLookup
    private WebElement login;
        
    public void setUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public void setPassword(String value) {
        password.clear();
        password.sendKeys(value);
    }
    
    public void submitLogin() {
        login.click();
    }
    
}

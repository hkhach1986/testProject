package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    String url = "https://screening.griddynamics.net/login";
    WebElement page;
    By login = By.xpath("//input[@name='login']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[text()='Log In']");

    public LoginPage(){
    }

    public void open(){
        openPage(url);
    }

    public void login(String email, String pwd){
        getDriver().findElement(login).sendKeys(email);
        getDriver().findElement(password).sendKeys(pwd);
        getDriver().findElement(loginButton).click();
    }
}

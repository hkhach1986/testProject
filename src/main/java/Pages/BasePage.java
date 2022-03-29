package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Driver {

    public void openPage(String url){
        getDriver().get(url);
    }

    public boolean isTextExists(String text){
        return getDriver().findElement(By.xpath("//*[contains(text(),'"+ text +"')]")).isDisplayed();
    }

    public String getAlertMessage(){
        new WebDriverWait(getDriver(), 30).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver dr) {
                return isAlertPresent();
            }
        });
        return getDriver().switchTo().alert().getText();
    }

    public boolean isAlertPresent()
    {
        try
        {
            getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }
}

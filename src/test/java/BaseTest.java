import Pages.BasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {

    @BeforeMethod()
    public void init(){
        initDriver();
    }

    @AfterClass
    public void killDriver(){
        getDriver().quit();
    }
}

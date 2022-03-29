package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static String driverPath = "src/main/java/drivers";
    public static ChromeDriver driver;
    WebDriverManager driverManager = WebDriverManager.chromedriver();
    public void initDriver(){
        installDriver();
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void installDriver(){
        if(!(new File(driverPath + "/chromedriver.exe")).exists()){
            driverManager.cachePath(driverPath).avoidOutputTree().setup();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}

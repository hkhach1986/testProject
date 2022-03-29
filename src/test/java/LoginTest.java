import Pages.LoginPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    @Parameters({"email","password","assert"})
    public void loginSmokeTest(String email, String password, String asserts){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(email, password);
        if (!asserts.equals("error"))
            Assert.assertTrue(isTextExists(asserts));
        else
            Assert.assertTrue(getAlertMessage().contains("Invalid credentials, please try again"));
    }
}

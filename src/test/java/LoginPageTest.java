import org.junit.Test;

/**
 * Created by Анастасия Цыбулько on 08.03.2017.
 */
public class LoginPageTest {

    static LoginPage loginPage;

    @Test
    public void chooseBrowser() {
        loginPage = new LoginPage();
        loginPage.setBrowser("firefox");
    }

    @Test
    public void login() throws InterruptedException {
        loginPage.login();
    }

    @Test
    public void sendMessage() throws InterruptedException {
        loginPage.sendMessage();
    }

    /*@After
    public void quitDriver() {
        loginPage.driver.quit();
    }*/

}

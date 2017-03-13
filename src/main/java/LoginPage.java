import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Анастасия Цыбулько on 07.03.2017.
 */
public class LoginPage {

    private static String URL = "https://gmail.com/";
    private static String LOGIN = "kitizena@gmail.com";
    private static String PASSWORD = "kitizeankitizean";

    private static String LOGIN_ID = "Email";
    private static String PASSWORD_ID = "Passwd";
    private static String TITLE = "Test title";
    private static String BODY = "Test body";
    WebDriver driver;
    private static String GECKO_DRIVER_PATH = "C:\\Users\\Анастасия Цыбулько\\Downloads\\geckodriver.exe";
    private static String CHROME_DRIVER_PATH = "C:\\Users\\Анастасия Цыбулько\\Downloads\\chromedriver_win32\\chromedriver.exe";

    public enum Browser {
        firefox, chrome
    }

    public void setBrowser(String browser) {

        Browser browserEnum = Browser.valueOf(browser);

        switch (browserEnum) {
            case firefox:
                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            default:
                break;
        }

        driver.get(URL);
    }

    public void login() throws InterruptedException {
        driver.findElement(By.id(LOGIN_ID)).sendKeys(LOGIN);
        driver.findElement(By.id("next")).click();
        Thread.sleep(2000);
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(PASSWORD);
        driver.findElement(By.id("signIn")).click();
    }

    public void sendMessage() throws InterruptedException {

        driver.findElement(By.id(LOGIN_ID)).sendKeys(LOGIN);
        driver.findElement(By.id("next")).click();
        Thread.sleep(2000);
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(PASSWORD);
        driver.findElement(By.id("signIn")).click();
        Thread.sleep(9000);
        driver.findElement(By.cssSelector(".T-I-KE")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#\\:83")).sendKeys(LOGIN);
        driver.findElement(By.cssSelector("#\\:7s")).sendKeys(TITLE);
        driver.findElement(By.cssSelector("#\\:8u")).sendKeys(BODY);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#\\:7i")).click();
        Thread.sleep(5000);

        if (driver.findElement(By.cssSelector(".b8 > div:nth-child(1) > div:nth-child(2)")).getText().equals("Письмо отправлено. Просмотреть сообщение")) {
            System.out.println("Письмо отправлено. Просмотреть сообщение");
        } else {
            System.out.println("Письмо не отправлено");
        }


    }

}
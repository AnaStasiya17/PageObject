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

        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[text() = \"НАПИСАТЬ\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@aria-label='Кому']")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//input[@placeholder='Тема']")).sendKeys(TITLE);
        driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).sendKeys(BODY);
        Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text() = 'Отправить']")).click();
        Thread.sleep(3000);

        if (driver.findElement(By.xpath("//div[@class='vh']")).getText().equals("Письмо отправлено. Просмотреть сообщение")) {
            System.out.println("Письмо отправлено. Просмотреть сообщение");
        } else {
            System.out.println("Письмо не отправлено");
        }


    }

}
package testForFireFoxBrowser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

//класс для подключения драйвера FireFox
public class ConnectFF {
    WebDriver driver;

    @Before
    //подключение браузера и установление ожидания в 5 секунд
    public void open() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //закрываю браузер
    @After
    public void close() {
        driver.quit();
    }
}
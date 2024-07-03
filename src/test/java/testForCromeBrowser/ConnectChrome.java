package testForCromeBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


    //подключение Chrome
    public class ConnectChrome {
        WebDriver driver;

        //подключение драйвера браузера и установление ожидания в 5 секунд
        @Before
        public void open() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }




        //закрываю браузер
        @After
        public void close() {
            driver.quit();
        }
    }



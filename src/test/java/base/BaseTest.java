package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import java.util.concurrent.TimeUnit;

//добавил дополнительный базовый класс, который содержит общий кода для открытия и закрытия браузера
public class BaseTest {
    protected WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void prepared() {
        driver = BrowserFactory.createDriver("chrome"); //или "firefox"
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //не совсем уверен, что его надо добавлять
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
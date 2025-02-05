import Locators.HomePageLocators;
import Locators.OrderPageLocators;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderButtonsTest {

    private WebDriver driver;

    @Before
    public void prepared() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        //неявное ожидание на автотест
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void clickHeaderButton() {
        HomePageLocators objHomepage = new HomePageLocators(driver);
        objHomepage.clickButtonHeaderOrder();
        OrderPageLocators objOrderpage = new OrderPageLocators(driver);
        //Открылась ли страница? Сравниваем ожидаемое значение с фактическим
        assertThat("Для кого самокат", is(objOrderpage.getHeaderText()));
    }

    @Test
    public void clickPageButton() {
        HomePageLocators objHomepage = new HomePageLocators(driver);
        objHomepage.clickButtonPageOrder();
        OrderPageLocators objOrderpage = new OrderPageLocators(driver);
        //Открылась ли страница? Сравниваем ожидаемое значение с фактическим
        assertThat("Для кого самокат", is(objOrderpage.getHeaderText()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

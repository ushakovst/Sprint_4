import Locators.HomePageLocators;
import Locators.OrderPageLocators;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String adress;
    private final String metroStation;
    private final String telephone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String checkbox;
    private final String comment;

    public OrderTest(String name, String surname, String adress, String metroStation, String telephone, String deliveryDate, String rentalPeriod, String checkbox, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.checkbox = checkbox;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] presetForOrder() {
        return new Object[][] {
                {"Алексей", "Шефцов", "Карликовая 25к1", "Фили", "+78005553535", "20.02.2025", "четверо суток", "серая безысходность", "Надеюсь, все заработает"},
                {"Игорь", "Кругликов", "Мужицкая 14", "Лубянка", "+78005553535", "14.02.2025", "семеро суток", "черный жемчуг", "Да, я богат"},
        };
    }


    @Before
    public void prepared() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //не совсем уверен, что его надо добавлять
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkOrderTest() {
        //объекты класса домашней и страницы заказа
        HomePageLocators objHomepage = new HomePageLocators(driver);
        OrderPageLocators objOrderpage = new OrderPageLocators(driver);

        //Закрываем куки
        objHomepage.clickButtonCookie();

        //нажать на кнопку "Заказать"
        objHomepage.clickButtonHeaderOrder();

        //"Заполнение" полей на странице "Для кого самокат"
        objOrderpage.setNameField(name);
        objOrderpage.setSurnameField(surname);
        objOrderpage.setAddressField(adress);
        objOrderpage.setMetroStationsField(metroStation);
        objOrderpage.setTelephoneField(telephone);
        //Клик на кнопку "Далее"
        objOrderpage.clickButtonNext();

        //"Заполнение" полей на странице "Про аренду"
        objOrderpage.setDeliveryDateField(deliveryDate);
        objOrderpage.setRentalPeriodField(rentalPeriod); //под вопросом, надо вернуться
        objOrderpage.clickCheckbox(checkbox);
        objOrderpage.setCommentsField(comment);
        //Клик на кнопку "Заказать", для подтверждения заказа
        objOrderpage.clickButtonOrder();
        //Клик на кнопку "Да"
        objOrderpage.clickButtonYes();

        //Открылось окошко, что заказ оформлен
        assertThat(objOrderpage.getTextOrderPlaced(),is("Заказ оформлен"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

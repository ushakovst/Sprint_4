import locators.HomePageLocators;
import locators.OrderPageLocators;
import base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String adress;
    private final String metroStation;
    private final String telephone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String checkbox;
    private final String comment;
    private final String headerOrderPlaced = "Заказ оформлен";

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
        objOrderpage.clickButtonYes(); //тест падает на подтверждении заказа

        //Открылось окошко, что заказ оформлен
        assertThat(objOrderpage.getTextOrderPlaced(),startsWith(headerOrderPlaced));
    }
}

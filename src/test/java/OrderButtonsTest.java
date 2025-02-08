import locators.HomePageLocators;
import locators.OrderPageLocators;
import base.BaseTest;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderButtonsTest extends BaseTest{

    private final String headerOrderText = "Для кого самокат";

    @Test
    public void clickHeaderButton() {
        HomePageLocators objHomepage = new HomePageLocators(driver);
        objHomepage.clickButtonHeaderOrder();
        OrderPageLocators objOrderpage = new OrderPageLocators(driver);
        //Открылась ли страница? Сравниваем ожидаемое значение с фактическим
        assertThat(headerOrderText, is(objOrderpage.getHeaderText()));
    }

    @Test
    public void clickPageButton() {
        HomePageLocators objHomepage = new HomePageLocators(driver);
        objHomepage.clickButtonPageOrder();
        OrderPageLocators objOrderpage = new OrderPageLocators(driver);
        //Открылась ли страница? Сравниваем ожидаемое значение с фактическим
        assertThat(headerOrderText, is(objOrderpage.getHeaderText()));
    }
}
import Locators.HomePageLocators;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuestionsTest {

    private WebDriver driver;

    @Before
    public void prepared() {
        //неявное ожидание
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAnswersTest() {

        HomePageLocators objHomePage = new HomePageLocators(driver);
        //закрываем куки
        objHomePage.clickButtonCookie();

        //пролистываем до вопрос/ответ
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[1]/div"));//(By.id("accordion__heading-24"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        objHomePage.clickButtonQuestion1();
        Assert.assertTrue(objHomePage.isAnswer1visioble());
        assertThat(objHomePage.getAnswer1(), is("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));

        objHomePage.clickButtonQuestion2();
        Assert.assertTrue(objHomePage.isAnswer2visioble());
        assertThat(objHomePage.getAnswer2(), is("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));

        objHomePage.clickButtonQuestion3();
        Assert.assertTrue(objHomePage.isAnswer3visioble());
        assertThat(objHomePage.getAnswer3(), is("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));

        objHomePage.clickButtonQuestion4();
        Assert.assertTrue(objHomePage.isAnswer4visioble());
        assertThat(objHomePage.getAnswer4(), is("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));

        objHomePage.clickButtonQuestion5();
        Assert.assertTrue(objHomePage.isAnswer5visioble());
        assertThat(objHomePage.getAnswer5(), is("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));

        objHomePage.clickButtonQuestion6();
        Assert.assertTrue(objHomePage.isAnswer6visioble());
        assertThat(objHomePage.getAnswer6(), is("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));

        objHomePage.clickButtonQuestion7();
        Assert.assertTrue(objHomePage.isAnswer7visioble());
        assertThat(objHomePage.getAnswer7(), is("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));

        objHomePage.clickButtonQuestion8();
        Assert.assertTrue(objHomePage.isAnswer8visioble());
        assertThat(objHomePage.getAnswer8(), is("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
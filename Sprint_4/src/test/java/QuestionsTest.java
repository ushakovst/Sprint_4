import Locators.HomePageLocators;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;

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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


        objHomePage.clickButtonQuestion1();
        objHomePage.isCorrectText(objHomePage.getAnswer1(),"Сутки — 400 рублей. Оплата курьеру — наличными или картой.");

        objHomePage.clickButtonQuestion2();
        objHomePage.isCorrectText(objHomePage.getAnswer2(),"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");

        objHomePage.clickButtonQuestion3();
        objHomePage.isCorrectText(objHomePage.getAnswer3(),"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");

        objHomePage.clickButtonQuestion4();
        objHomePage.isCorrectText(objHomePage.getAnswer4(),"Только начиная с завтрашнего дня. Но скоро станем расторопнее.");

        objHomePage.clickButtonQuestion5();
        objHomePage.isCorrectText(objHomePage.getAnswer5(),"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");

        objHomePage.clickButtonQuestion6();
        objHomePage.isCorrectText(objHomePage.getAnswer6(),"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");

        objHomePage.clickButtonQuestion7();
        objHomePage.isCorrectText(objHomePage.getAnswer7(),"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");

        objHomePage.clickButtonQuestion8();
        objHomePage.isCorrectText(objHomePage.getAnswer8(),"Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageLocators {
    private final WebDriver driver;

    //локатор кнопки для закрытия куки "да все привыкли"
    private final By buttonCookie = By.id("rcc-confirm-button");

    //локатор кнопки выпадающего списка
    private final By faqButton = By.className("accordion__heading");

    //локатор ответа на вопрос
    private final By faqAnswer = By.xpath(".//div[@class='accordion__panel']/p");

    //локатор кнопки "Заказать" в шапке домашней страницы
    private final By buttonHeaderOrder = By.cssSelector(".Button_Button__ra12g");

    //локатор кнопки "Заказать"
    private final By buttonPageOrder = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    //конструктор вебдрайвера
    public HomePageLocators (WebDriver driver) {
        this.driver = driver;
    }

    //клик по кнопке куки "да все привыкли"
    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }

    //клик по кнопке "Заказать" в шапке домашней страницы
    public void clickButtonHeaderOrder() {
        driver.findElement(buttonHeaderOrder).click();
    }

    //клик по кнопке "Заказать" на домашней странице. Предварительно до него надо "докрутить" страницу
    public void clickButtonPageOrder() {
        WebElement element = driver.findElement(buttonPageOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonPageOrder).click();
    }

    //клик на кнопки выпадающего списка
    public void clickFAQButton(int index) {
        driver.findElements(faqButton).get(index).click();
    }

    //геттер для получения локатора нужной кнопки
    public By getFaqButton() {
        return faqButton;
    }

    //геттеры получения текста ответа на вопрос
    public String getFAQanswer(int index) {
        return driver.findElements(faqAnswer).get(index).getText();
    }

    //метод для ожидания появления нужного элемента в FAQ
    public void waitForLoading(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElements(faqAnswer).get(index)));
    }
}
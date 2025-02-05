package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocators {
    private final WebDriver driver;

    //локатор кнопки для закрытия куки "да все привыкли"
    private final By buttonCookie = By.id("rcc-confirm-button");

    //локаторы кнопок выпадающего списка
    private final By buttonQuestion1 = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private final By buttonQuestion2 = By.id("accordion__heading-1");
    private final By buttonQuestion3 = By.id("accordion__heading-2");
    private final By buttonQuestion4 = By.id("accordion__heading-3");
    private final By buttonQuestion5 = By.id("accordion__heading-4");
    private final By buttonQuestion6 = By.id("accordion__heading-5");
    private final By buttonQuestion7 = By.id("accordion__heading-6");
    private final By buttonQuestion8 = By.id("accordion__heading-7");

    //локаторы для получения ответа на вопросы
    private final By answer1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By answer2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By answer3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By answer4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By answer5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By answer6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By answer7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By answer8 = By.xpath(".//div[@id='accordion__panel-7']/p");

    //локатор кнопки "Заказать" в шапке домашней страницы
    private final By buttonHeaderOrder = By.cssSelector(".Button_Button__ra12g");

    //локатор кнопки "Заказать"
    private final By buttonPageOrder = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

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
    public void clickButtonQuestion1() {
        driver.findElement(buttonQuestion1).click();
    }
    public void clickButtonQuestion2() {
        driver.findElement(buttonQuestion2).click();
    }
    public void clickButtonQuestion3() {
        driver.findElement(buttonQuestion3).click();
    }
    public void clickButtonQuestion4() {
        driver.findElement(buttonQuestion4).click();
    }
    public void clickButtonQuestion5() {
        driver.findElement(buttonQuestion5).click();
    }
    public void clickButtonQuestion6() {
        driver.findElement(buttonQuestion6).click();
    }
    public void clickButtonQuestion7() {
        driver.findElement(buttonQuestion7).click();
    }
    public void clickButtonQuestion8() {
        driver.findElement(buttonQuestion8).click();
    }

    //геттеры получения текста ответа на вопрос
    public String getAnswer1() {
        return driver.findElement(answer1).getText();
    }
    public String getAnswer2() {
        return driver.findElement(answer2).getText();
    }
    public String getAnswer3() {
        return driver.findElement(answer3).getText();
    }
    public String getAnswer4() {
        return driver.findElement(answer4).getText();
    }
    public String getAnswer5() {
        return driver.findElement(answer5).getText();
    }
    public String getAnswer6() {
        return driver.findElement(answer6).getText();
    }
    public String getAnswer7() {
        return driver.findElement(answer7).getText();
    }
    public String getAnswer8() {
        return driver.findElement(answer8).getText();
    }

    public boolean isAnswer1visioble() {
        return driver.findElement(answer1).isDisplayed();
    }
    public boolean isAnswer2visioble() {
        return driver.findElement(answer2).isDisplayed();
    }
    public boolean isAnswer3visioble() {
        return driver.findElement(answer3).isDisplayed();
    }
    public boolean isAnswer4visioble() {
        return driver.findElement(answer4).isDisplayed();
    }
    public boolean isAnswer5visioble() {
        return driver.findElement(answer5).isDisplayed();
    }
    public boolean isAnswer6visioble() {
        return driver.findElement(answer6).isDisplayed();
    }
    public boolean isAnswer7visioble() {
        return driver.findElement(answer7).isDisplayed();
    }
    public boolean isAnswer8visioble() {
        return driver.findElement(answer8).isDisplayed();
    }
}
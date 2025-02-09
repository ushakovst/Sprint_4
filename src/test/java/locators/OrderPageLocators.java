package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageLocators {
    private final WebDriver driver;

    //Страница "Для кого самокат"
    //локатор поля "Имя"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля "Адрес: куда привезти заказ"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор селектора станций метро
    private final By metroStationsField = By.className("select-search__input");
    //локатор станции метро, который расположен первым в выпадающем списке
    private final By metroStationList = By.xpath(".//li[@data-index='0']/button");
    //локатор поля "Телефон"
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private final By buttonNext = By.xpath(".//button[text()='Далее']");
    //локатр заголовка "Для кого самокат", для определения того, открылась ли страница
    private final By headerText = By.className("Order_Header__BZXOb");


    //Страница "Про Аренду"
    //локатор поля "Когда привезти самокат"
    private final By deliveryDateField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //локатор даты в календаре, которая появляется после ввода данных в поле
    private final By deliveryDateCalendar = By.xpath(".//div[@tabindex='0' and @role='button']");
    //локатор поля "Срок аренды"
    private final By rentalPeriodField = By.className("Dropdown-control");
    //локаторы данных срока аренды
    //сутки
    private final By oneDay = By.xpath(".//div[text()='сутки']");
    //двое суток
    private final By twoDays = By.xpath(".//div[text()='двое суток']");
    //трое суток
    private final By threeDays = By.xpath(".//div[text()='трое суток']");
    //четверо суток
    private final By fourDays = By.xpath(".//div[text()='четверо суток']");
    //пятеро суток
    private final By fiveDays = By.xpath(".//div[text()='пятеро суток']");
    //шестеро суток
    private final By sixDays = By.xpath(".//div[text()='шестеро суток']");
    //семеро суток
    private final By sevenDays = By.xpath(".//div[text()='семеро суток']");
    //локатор чекбокса "черный жемчуг"
    private final By checkboxBlack = By.xpath(".//label[@for='black']");
    //локатор чекбокса "серая безысходность"
    private final By checkboxGrey = By.xpath(".//label[@for='grey']");
    //локатор поля "Комментарии для курьера"
    private final By commentsField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки "Заказать", для подтверждения заказа
    private final By buttonOrder = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Страница Хотите оформить заказ?
    //локатор кнопки "Да"
    private final By buttonYes = By.xpath(".//button[text()='Да']");

    //Окошко Заказ оформлен
    //Локатор фразы "Заказ оформлен" в окошке
    private final By orderPlaced = By.className("Order_ModalHeader__3FDaJ");

    public OrderPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    //Страница "Для кого самокат"
    //Заполнение поля "Имя"
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Заполнение поля "Фамилия"
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //Заполнение поля "Адрес: куда привезти заказ"
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Заполнение селектора станции метро !!!
    //Не уверен, что правильно!
    public void setMetroStationsField(String station) {
        driver.findElement(metroStationsField).click();
        driver.findElement(metroStationsField).sendKeys(station);
        driver.findElement(metroStationList).click();
    }

    //Заполнение поля "Телефон"
    public void setTelephoneField(String number) {
        driver.findElement(telephoneField).sendKeys(number);
    }

    //Клик по кнопке "Далее"
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //Получаем текст заголовка
    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    //Страница "Про Аренду"
    //Заполнение поля "Когда привезти самокат"
    public void setDeliveryDateField(String date) {
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateField).sendKeys(date);
        driver.findElement(deliveryDateCalendar).click(); //тоже под вопросом
    }

    //Заполнение поля "Срок аренды"
    public void setRentalPeriodField(String rentalPeriod) { // не уверен в этом методе
        driver.findElement(rentalPeriodField).click();
        String toLowerCaseRentalPeriod = rentalPeriod.toLowerCase();
        switch (toLowerCaseRentalPeriod) {
            case "сутки":
                driver.findElement(oneDay).click();
                break;
            case "двое суток":
                driver.findElement(twoDays).click();
                break;
            case "трое суток":
                driver.findElement(threeDays).click();
                break;
            case "четверо суток":
                driver.findElement(fourDays).click();
                break;
            case "пятеро суток":
                driver.findElement(fiveDays).click();
                break;
            case "шестеро суток":
                driver.findElement(sixDays).click();
                break;
            case "семеро суток":
                driver.findElement(sevenDays).click();
                break;
        }
    }

    //Клик чекбокса, используя условный оператор
    public void clickCheckbox(String checkbox) {
        if (checkbox.equalsIgnoreCase("черный жемчуг")) {
            driver.findElement(checkboxBlack).click();
        } else if (checkbox.equalsIgnoreCase("серая безысходность")) {
            driver.findElement(checkboxGrey).click();
        }
    }

    //Заполнение поля "Комментарий"
    public void setCommentsField(String comment) {
        driver.findElement(commentsField).sendKeys(comment);
    }

    //Клик кнопки заказать для подтверждения заказа
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //Страница Хотите оформить заказ?
    //Клик по кнопке "Да"
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    //Окошко Заказ оформлен
    //Проверка, действительно ли оформлен заказ
    //Из локатора получаем текст
    public String getTextOrderPlaced() {
        return driver.findElement(orderPlaced).getText();
    }
}

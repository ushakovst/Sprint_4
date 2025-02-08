package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//созжаем фабрику для выбора одного из двух браузеров
public class BrowserFactory {
    public static WebDriver createDriver(String browser) {
        if (browser.equals("firefox")) {
            return new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            return new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
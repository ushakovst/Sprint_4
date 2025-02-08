package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//созжаем фабрику для выбора одного из двух браузеров
/*
/Честно говоря, я всю голову сломал и не разобрался оканчательно, что необходимо сделать,
/чтобы вебдрайвер подсасывался на любую систему и запускался
*/
public class BrowserFactory {
    public static WebDriver createDriver(String browser) {
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        if (browser.equals("firefox")) {
            return new FirefoxDriver();  //WebDriverManager.firefoxdriver().win().arch32().driverVersion("0.35.0").create();
        } else if (browser.equals("chrome")) {
            return WebDriverManager.chromedriver().create();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
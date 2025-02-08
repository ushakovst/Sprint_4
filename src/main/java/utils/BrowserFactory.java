package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//созжаем фабрику для выбора одного из двух браузеров
/*
/Честно говоря, я всю голову сломал и не разобрался оканчательно, что необходимо сделать,
/чтобы вебдрайвер подсасывался на любую систему и запускался
*/
public class BrowserFactory {
    public static WebDriver createDriver(String browser) {
        if (browser.equals("firefox")) {
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();  //WebDriverManager.firefoxdriver().win().arch32().driverVersion("0.35.0").create();
        } else if (browser.equals("chrome")) {
            WebDriverManager.firefoxdriver().setup();
            return new ChromeDriver(); //WebDriverManager.chromedriver().create();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
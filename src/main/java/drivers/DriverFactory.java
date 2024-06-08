package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(BrowserType browserType) {

        switch (browserType) {
            case CHROME:
                drivers.set(new ChromeDriver());
                break;
            case FIREFOX:
                drivers.set(new FirefoxDriver());
                break;
            case EDGE:
                drivers.set(new EdgeDriver());
                break;
        }
        return drivers.get();
    }

    public enum BrowserType{
        CHROME,
        FIREFOX,
        EDGE
    }

}

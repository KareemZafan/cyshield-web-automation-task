package pages;

import element_actions.Element;
import io.PropertiesFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final PropertiesFileManager props;
    private final Element element;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        props = new PropertiesFileManager("src/main/resources/app-utils");
    }

    public HomePage open() {
        driver.get(props.getProperty("URL"));
        return this;
    }

    public HomePage navigateTo(String title) {
        element.click(By.partialLinkText(title));
        return this;
    }
}

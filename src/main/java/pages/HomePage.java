package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://automationexercise.com/");
    }

    public void navigateTo(String title){
        driver.findElement(By.partialLinkText(title)).click();
    }
}

package element_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Element {
    private WebDriver driver;
    private WebDriverWait wait;
    Actions actions;

    public Element(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public String getElementText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public Element click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        return this;
    }

    public Element type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public Element selectOptionWithVisibleText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        select.selectByVisibleText(text);
        return this;
    }

    public Element clickOnCheckbox(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        driver.findElement(locator).click();
        return this;
    }

    public String getElementAttribute(By locator, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator).getAttribute(attribute);
    }

    public Element clear(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
         driver.findElement(locator).clear();
         return this;
    }

    public Element clickAndHold(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.clickAndHold(driver.findElement(locator)).perform();
        return this;
    }

    public boolean isSelected(By locator){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return  driver.findElement(locator).isSelected();
    }

    public boolean dropDownOptionIsSelected(By locator, String optionText) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        Select select = new Select(driver.findElement(locator));
        return select.getAllSelectedOptions().contains(optionText);

    }



}

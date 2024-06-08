package element_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Element {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public Element(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
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

    public Element clickAndHold(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.clickAndHold(driver.findElement(locator)).perform();
        return this;
    }

    public Element scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public Element scrollBy(int start, int end) {
        javascriptExecutor.executeScript(String.format("window.scrollBy(%d,%d)", start, end));
        return this;
    }

    public Element scrollToEnd() {
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        return this;
    }

    public boolean isSelected(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator).isSelected();
    }

    public boolean isDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator).isDisplayed();
    }

    public Element acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    public Element dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        return this;
    }

    public String getAlertText() {
       return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    public boolean dropDownOptionIsSelected(By locator, String optionText) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        Select select = new Select(driver.findElement(locator));
        return select.getAllSelectedOptions().contains(optionText);

    }
}

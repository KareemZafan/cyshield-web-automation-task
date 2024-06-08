package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    private WebDriver driver;
    private Element elementActions;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        elementActions = new Element(driver);
    }

    public void register(String name, String email) {
        elementActions.type(By.cssSelector("div.signup-form input[name='name']"), name);
        elementActions.type(By.cssSelector("div.signup-form input[name='email']"), email);
        elementActions.click(By.cssSelector("div.signup-form button"));
    }

    public void enterTitle(Gender gender) {
        switch (gender) {
            case MALE:
                elementActions.click(By.id("id_gender1"));
                break;
            case FEMALE:
                elementActions.click(By.id("id_gender2"));
                break;
        }

    }

    public void enterName(String name) {
        elementActions.clear(By.id("name"));
        elementActions.type(By.id("name"), name);
    }

    public void enterEmail(String email) {
        elementActions.clear(By.id("email"));
        elementActions.type(By.id("email"), email);
    }

    public void enterPassword(String password) {
        elementActions.clear(By.id("password"));
        elementActions.type(By.id("password"), password);
    }

    public void selectYear(String year) {
        elementActions.selectOptionWithVisibleText(By.id("years"), year);
    }

    public void selectMonth(String month) {
        elementActions.selectOptionWithVisibleText(By.id("months"), month);
    }

    public void selectDay(String day) {
        elementActions.selectOptionWithVisibleText(By.id("days"), day);
    }

    public void selectOptionWithText(String text) {
        elementActions.click(By.xpath(String.format("//label[contains(text(),'%s')]/..//input", text)));
    }

    //todo add rest of functionalities

    public enum Gender {
        MALE, FEMALE
    }
}

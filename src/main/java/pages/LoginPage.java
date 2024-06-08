package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final Element element;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
    }

    public LoginPage enterUserId(String userId) {
        element.type(By.name("userid"), userId);
        return this;

    }

    public LoginPage enterUserPassword(String password) {
        element.type(By.name("passid"), password);
        return this;
    }

    public LoginPage enterUserName(String username) {
        element.type(By.name("username"), username);
        return this;
    }

    public LoginPage enterUserAddress(String address) {
        element.type(By.name("address"), address);
        return this;
    }

    public LoginPage selectUserCountry(String country) {
        element.selectOptionWithVisibleText(By.name("country"), country);
        return this;
    }

    public LoginPage enterZipCode(String zipCode) {
        element.type(By.name("zip"), zipCode);
        return this;
    }

    public LoginPage enterUserEmail(String email) {
        element.type(By.name("email"), email);
        return this;
    }

    public LoginPage selectEnglishLanguage() {
        if (!element.getElementAttribute(By.cssSelector("input[name='languageQuestion']"), "checked").equalsIgnoreCase("true")) {
            element.click(By.cssSelector("input[name='languageQuestion']"));
        }
        return this;
    }

    public LoginPage deSelectEnglishLanguage() {
        if (element.getElementAttribute(By.cssSelector("input[name='languageQuestion']"), "checked").equalsIgnoreCase("true")) {
            element.click(By.cssSelector("input[name='languageQuestion']"));
        }
        return this;
    }

    public LoginPage fillAboutSection(String text) {
        element.type(By.id("desc"), text);
        return this;
    }

    public LoginPage selectSex(Gender gender) {
        switch (gender) {
            case MALE:
                element.click(By.cssSelector("input[value='Male']"));
                break;
            case FEMALE:
                element.click(By.cssSelector("input[value='Female']"));
                break;
        }
        return this;
    }

    public void clickSubmit() {
        element.click(By.name("submit"));
    }

    public boolean isRegistrationFormDisplayed() {

        return element.isDisplayed(By.name("registration"));
    }

    public enum Gender {
        MALE, FEMALE
    }
}

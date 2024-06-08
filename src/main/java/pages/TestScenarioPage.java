package pages;

import element_actions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestScenarioPage {
    private final WebDriver driver;
    private final Element element;

    public TestScenarioPage(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
    }

    public TestScenarioPage enterUserId(String userId) {
        element.type(By.name("userid"), userId);
        return this;

    }

    public TestScenarioPage enterUserPassword(String password) {
        element.type(By.name("passid"), password);
        return this;
    }

    public TestScenarioPage enterUserName(String username) {
        element.type(By.name("username"), username);
        return this;
    }

    public TestScenarioPage enterUserAddress(String address) {
        element.type(By.name("address"), address);
        return this;
    }

    public TestScenarioPage selectUserCountry(String country) {
        element.selectOptionWithVisibleText(By.name("country"), country);
        return this;
    }

    public TestScenarioPage enterZipCode(String zipCode) {
        element.type(By.name("zip"), zipCode);
        return this;
    }

    public TestScenarioPage enterUserEmail(String email) {
        element.type(By.name("email"), email);
        return this;
    }

    public TestScenarioPage selectEnglishLanguage() {
        if (!element.getElementAttribute(By.cssSelector("input[name='languageQuestion']"), "checked").equalsIgnoreCase("true")) {
            element.click(By.cssSelector("input[name='languageQuestion']"));
        }
        return this;
    }

    public TestScenarioPage deSelectEnglishLanguage() {
        if (element.getElementAttribute(By.cssSelector("input[name='languageQuestion']"), "checked").equalsIgnoreCase("true")) {
            element.click(By.cssSelector("input[name='languageQuestion']"));
        }
        return this;
    }

    public TestScenarioPage fillAboutSection(String text) {
        element.type(By.id("desc"), text);
        return this;
    }

    public TestScenarioPage selectSex(Gender gender) {
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

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

    public RegistrationPage navigateToRegisterForm() {
        element.click(By.partialLinkText("Register Form"));
        return new RegistrationPage(driver);
    }

    public LoginPage navigateToLoginForm() {
        element.click(By.partialLinkText("Login Form"));
        return new LoginPage(driver);
    }

}

package base_tests;

import drivers.DriverFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.TestScenarioPage;

public class BaseTests {

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected TestScenarioPage testScenarioPage;
    protected static DriverFactory driverFactory = new DriverFactory();


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driverFactory.setDriver(DriverFactory.BrowserType.CHROME);
                break;
            case "firefox":
                driverFactory.setDriver(DriverFactory.BrowserType.FIREFOX);
            default:
                driverFactory.setDriver(DriverFactory.BrowserType.CHROME);
        }
        driverFactory.getDriver().manage().window().maximize();
        homePage = new HomePage(driverFactory.getDriver());
        registrationPage = new RegistrationPage(driverFactory.getDriver());
        testScenarioPage = new TestScenarioPage(driverFactory.getDriver());
        loginPage = new LoginPage(driverFactory.getDriver());
    }

    @AfterTest
    public void tearDown() {
        driverFactory.getDriver().quit();

    }

}

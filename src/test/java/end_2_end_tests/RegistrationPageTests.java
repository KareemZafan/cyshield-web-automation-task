package end_2_end_tests;

import element_actions.Element;
import base_tests.BaseTests;
import io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RegistrationPageTests extends BaseTests {
    private JSONFileManager jsonFileManager;
    private Element element;

    @BeforeClass
    void beforeClass() {
        element = new Element(driverFactory.getDriver());
    }

    @BeforeMethod
    void beforeEachTestcase() {
        homePage.open();
        homePage.navigateTo("TEST SCENARIOS");
        testScenarioPage.navigateToRegisterForm();
        element.scrollBy(0, 1000);
    }

    @Test
    void checkVisibilityOfRegistrationFormElements() {
        assertTrue(registrationPage.isRegistrationFormDisplayed(), "Registration Form Not Ready!");
    }

    @Test
    void testRegistrationWithValidData() {
        try {

            jsonFileManager = new JSONFileManager("src/test/resources/users_valid_test_data.json");

            for (int i = 0; i < 3; i++) {

                // Arrange

                registrationPage
                        .enterUserId(jsonFileManager.getStringObject(String.format("$.users[%d].userId", i)))
                        .enterUserPassword(jsonFileManager.getStringObject(String.format("$.users[%d].password", i)))
                        .enterUserName(jsonFileManager.getStringObject(String.format("$.users[%d].name", i)))
                        .enterUserAddress(jsonFileManager.getStringObject(String.format("$.users[%d].address", i)))
                        .selectUserCountry(jsonFileManager.getStringObject(String.format("$.users[%d].country", i)))
                        .enterZipCode(jsonFileManager.getStringObject(String.format("$.users[%d].zipCode", i)))
                        .enterUserEmail(jsonFileManager.getStringObject(String.format("$.users[%d].email", i)))
                        .selectSex(jsonFileManager.getStringObject(String.format("$.users[%d].sex", i)).equalsIgnoreCase("Male") ? RegistrationPage.Gender.MALE : RegistrationPage.Gender.FEMALE);
                boolean isEnglish = jsonFileManager.getStringObject(String.format("$.users[%d].english", i)).equalsIgnoreCase("true");
                if (isEnglish) {
                    registrationPage.selectEnglishLanguage();
                } else {
                    registrationPage.deSelectEnglishLanguage();
                }
                registrationPage.fillAboutSection(jsonFileManager.getStringObject(String.format("$.users[%d].about", i))).clickSubmit();

                //Actions
                homePage.open().navigateTo("TEST SCENARIOS").navigateTo("Login Form");

                loginPage
                        .enterUserName(jsonFileManager.getStringObject(String.format("$.users[%d].name", i)))
                        .enterPassword(jsonFileManager.getStringObject(String.format("$.users[%d].password", i)))
                        .enterRepeatPassword(jsonFileManager.getStringObject(String.format("$.users[%d].password", i)))
                        .clickLoginButton();


                //Assert
                assertTrue(loginPage.isUserLoggedInSuccessfully());

                homePage.open().navigateTo("TEST SCENARIOS").navigateTo("Register Form");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testRegistrationWithInValidData() {
        try {
            jsonFileManager = new JSONFileManager("src/test/resources/users_invalid_test_data.json");
            for (int i = 0; i < 4; i++) {

                // Arrange
                registrationPage.enterUserId(jsonFileManager.getStringObject(String.format("$.users[%d].userId", i))).enterUserPassword(jsonFileManager.getStringObject(String.format("$.users[%d].password", i))).enterUserName(jsonFileManager.getStringObject(String.format("$.users[%d].name", i))).enterUserAddress(jsonFileManager.getStringObject(String.format("$.users[%d].address", i))).selectUserCountry(jsonFileManager.getStringObject(String.format("$.users[%d].country", i))).enterZipCode(jsonFileManager.getStringObject(String.format("$.users[%d].zipCode", i))).enterUserEmail(jsonFileManager.getStringObject(String.format("$.users[%d].email", i))).selectSex(jsonFileManager.getStringObject(String.format("$.users[%d].sex", i)).equalsIgnoreCase("Male") ? RegistrationPage.Gender.MALE : RegistrationPage.Gender.FEMALE);
                boolean isEnglish = jsonFileManager.getStringObject(String.format("$.users[%d].english", i)).equalsIgnoreCase("true");
                if (isEnglish) {
                    registrationPage.selectEnglishLanguage();
                } else {
                    registrationPage.deSelectEnglishLanguage();
                }
                registrationPage.fillAboutSection(jsonFileManager.getStringObject(String.format("$.users[%d].about", i))).clickSubmit();

                // Assert
                assertFalse(registrationPage.isUserAbleToProceed());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

# Web Automation Project

## Overview

This project is designed to automate testing of the registration and login flow for this
website https://testing.todorvachev.com/  using selenium, TestNG and Allure is used for
generating detailed test reports.

## Prerequisites

- Java JDK 17 or higher
- Maven

## Setup Instructions

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/KareemZafan/cyshield-web-automation-task.git
    cd cyshield-web-automation-task
    ```

2. **Run Tests**:
    ```sh
    mvn clean -DxmlFile=testng.xml test
    ```

3. **Generate Allure Report**:
    ```sh
      allure generate --clean
    ```

4. **Open Allure Report**:
    ```sh
      allure open 
    ```

## Project Structure

- `pom.xml`: Maven configuration file with dependencies.
- `testng.xml`: TestNG configuration file.
- `src/main/java/drivers`: Contains a class called DriverFactory which is needed to initialize webdriver to open
  sessions with your browsers.
- `src/main/java/element_actions`: Contains a class called Element which is needed to interact with multiple different
  web element such click on element, typing on element or getting element text and so on.
- `src/main/java/io`: Contains classes by which we can read data from external input/output files such as json,csv or
  properties file formats.
- `src/main/java/pages`: Contains the classes represent each single page like home, registration or login pages in our
  website this implementation of POM design pattern.
- `src/main/resources`: Contains app-utils.properties file in which we are storing some common variable such app-url or
  different environments' urls.
- `src/test/java/base_tests`: Contains a class by which we can organize and initialize tests in addition setting all
  drivers up for all other test classes usually it needs to be extended by others.
  app-url or different environments' urls.
- `e2e_tests`: Contains all test class for this application, we have only single class "RegistrationPageTests" in this
  class
    - we need to make sure that
        - all element are visible for the registration form
        - registration is working fine against extensive test data coming from json file with valid test data to be
          filled out.
        - Continuing with valid data we are also checking that the registered user can log in to the application also it
          checks against extensive data is coming form json file.
        - registration is not working while inserting invalid data coming from json file and checking the different
          reasons of the incompleteness
- `src/test/resources`: Contains json files that hold the valid and invalid users' details.
- `Readme.txt`: Instructions on how to set up and run the project.

## Test Cases

1. **Check All Elements Are Visible**: Validates if registration form with its components are visible or not.
2. **Check Register with Valid data**: Validates registration for three users with their data stored in this file "
   src/test/resources/users_valid_test_data.json"
   then login for these users to make sure that the registration was done.
3. **Check Register with Invalid data**: Validates registration will not proceed with invalid 4 users' data stored in
   this file "src/test/resources/users_invalid_test_data.json"
   in addition to check the root cause of not to proceed.

## Reports

Allure is used to generate detailed reports. Follow the setup instructions to generate and view the report.

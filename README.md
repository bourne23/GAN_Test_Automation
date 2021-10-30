# Automation Tester Pre-Interview Test

This is a Java Selenium Cucumber project containing test scenario to test moneygaming.com application. 

## Environments
- The Java SE Development Kit must be installed
- Maven must be installed
- You can run the test in chrome, chrome-headless and edge browsers. Make sure you have them installed on your machine.

## To run a test use the following command:
```
mvn clean test -Dbrowser=chrome -Dtest=RunCukesTest -Dcucumber.options="--tags @registration"
``` 

## Notes:
The Requirement for the this test case describes a user registration process starting from the home page https://moneygaming.qa.gameaccount.com/, and doesn't mention one additional step.

I have included it in my test script:
``` 
- From the home page: click "JOIN NOW!" button (in the top right corner) to be redirected to the sign up form. 
  Continue registration, select title, etc.
```

`Submitted by Olessya Foxborn`

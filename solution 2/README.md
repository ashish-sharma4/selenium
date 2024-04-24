## Environment:
- Java version: 11
- Maven version: 3.*
- Selenium HtmlUnitDriver: 2.52.0

## Read-Only Files:
- src/test/*
- website/*
- src/main/java/com/speedhire/selenium/server/*

## Requirements:
In this challenge, you are going to use selenium web driver, the HtmlUnitDriver, which uses HtmlUnit headless browser. So you neither need to setup the browsers like Firefox, Chrome nor a web driver executables like FirefoxDriver, ChromeDriver.
You are given a URL for an Annual Fee Analytics application. Your task is to verify that each students’ Annual Fee Payment is equivalent to the summation of the different payments made against student id. In case, there is a mismatch between the two values, you need to return that student id.


There are tests for testing correctness of each methods. So you can make use of these tests while debugging/checking your implementation.
The test's setup method bootstraps an embedded jetty server and deploys small web app which displays randomly generated website. 
The example website is given in the `website` folder where you can view the structure of search page and result page but data displayed are random and will change on every refresh.

The provided `studentPageUrl` page will look like: 

![web page1](studentPage.png)

The provided `paymentsPageUrl` page will look like: 

![web page2](paymentsPage.png)

NOTE:
- For each student, there will be separate payments page
- The payments page in the above example is the result of drilling down from student p01's total paid amount 600.
- Total paid amount is the anchor to payments data.

Your task is to complete the implementation of `FeeAnalytics` so that the unit tests pass while running the tests.

## Commands
- run: 
```bash
mvn clean package && java -jar target/selenium-fee-analytics-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
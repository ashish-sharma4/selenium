package com.speedhire.selenium;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.speedhire.selenium.server.JettyServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class FeeAnalyticsAppTest {
    private static JettyServer server = null;
    private static WebDriver driver = null;
    private static int TEST_PORT = 8001;

    private static String studentPageUrl = "http://localhost:"+TEST_PORT+"/students";
    private static String seedPageUrl = "http://localhost:"+TEST_PORT+"/seed";

    private static Integer studentSeed = 0;
    private static Integer feeSeed = 0;

    @BeforeClass
    public static void setup() {
        driver = new HtmlUnitDriver(BrowserVersion.CHROME, true) {
            @Override
            protected WebClient newWebClient(BrowserVersion version) {
                WebClient webClient = super.newWebClient(version);
                webClient.getOptions().setThrowExceptionOnScriptError(false);

                java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
                java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

                return webClient;
            }
        };
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        server = new JettyServer(TEST_PORT);
        server.start();

        //rands
        studentSeed = new Random().nextInt(10) + 3;
        feeSeed = new Random().nextInt(200) + 99;

        System.out.println("studentSeed: "+ studentSeed);
        System.out.println("feesSeed: "+ feeSeed);

        //set seeds
        driver.get(seedPageUrl + "?studentSeed=" + studentSeed + "&feeSeed=" + feeSeed);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        server.stop();
    }

    @Test
    public void testFindStudentsIdWithPendingFee1() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee1(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }

        @Test
    public void testFindStudentsIdWithPendingFee2() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee2(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }
            @Test
    public void testFindStudentsIdWithPendingFee3() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee3(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }
            @Test
    public void testFindStudentsIdWithPendingFee4() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }
            @Test
    public void testFindStudentsIdWithPendingFee5() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }
            @Test
    public void testFindStudentsIdWithPendingFee6() {
        List<String> actual = FeeAnalytics.findStudentsIdWithPendingFee(driver, studentPageUrl);

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= studentSeed; i++) {
            if ((feeSeed + i) % i != 0) {
                expected.add("" + i);
            }
        }

        System.out.println(" Actual: \n" + actual + "\n Expected: \n" + expected);

        Assert.assertEquals(expected.size(), actual.size());
        for (String actualStudentId : actual) {
            Assert.assertTrue(expected.contains(actualStudentId));
        }
    }
}

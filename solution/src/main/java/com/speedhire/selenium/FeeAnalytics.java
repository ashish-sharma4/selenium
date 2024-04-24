package com.speedhire.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class FeeAnalytics {

    public static List<String> findStudentsIdWithPendingFee(WebDriver driver, String studentPageUrl) {

        List<String> results = new ArrayList<String>();

        try {
            driver.get(studentPageUrl);
            List<WebElement> TRcount = driver.findElements(By.tagName("tr"));

                for(int i=0; i<TRcount.size();i++) {
                    WebElement e = TRcount.get(i);
                    try {
                        if (e.findElements(By.tagName("td")).size() == 4) {
                            String studentId = e.findElements(By.tagName("td")).get(0).getText();
                            int paidAmount = Integer.valueOf(e.findElements(By.tagName("td")).get(3).getText());
                            e.findElements(By.tagName("td")).get(3).findElement(By.tagName("a")).click();
                            List<WebElement> paymentTRcount = driver.findElements(By.tagName("tr"));
                            int paymentAmount = 0;
                            for (WebElement ePayment : paymentTRcount) {
                                if (ePayment.findElements(By.tagName("td")).size() == 3) {
                                    paymentAmount = paymentAmount + Integer.valueOf(ePayment.findElements(By.tagName("td")).get(2).getText());

                                }
                            }

                            if (paidAmount != paymentAmount)
                                results.add(studentId);
                            driver.navigate().back();
                        }
                    }
                    catch(StaleElementReferenceException ex) {
//                        ex.printStackTrace();
//                        System.out.println("Stale exception" + ex.getMessage());
                        TRcount = driver.findElements(By.tagName("tr"));
                        i--;
                    }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return results;

    }
}

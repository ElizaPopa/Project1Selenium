package com.first.pachet;

import org.testng.annotations.*;

public class SeleniumAnnotations {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @BeforeGroups(groups = {"Grupul 1"})
    public void beforeGroups() {
        System.out.println("Before Groups");
    }
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @BeforeClass(groups = {"Grupul 1"})
    public void beforeGroupClass() {
        System.out.println("Before Group Class");
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @Test(groups = {"Grupul 1"})
    public void test1() {
        System.out.println("Test 1");
    }
    @Test(groups = {"Grupul 2"})
    public void test2() {
        System.out.println("Test 2");
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("After Method");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("After Class");
    }
    @AfterGroups(groups = {"Grupul 1"})
    public void afterGroups() {
        System.out.println("After Groups");
    }
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("After Test");
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("After Suite");
    }
}

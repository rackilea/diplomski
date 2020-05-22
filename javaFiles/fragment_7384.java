package com.rationaleemotions.stackoverflow.qn51160440;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClassSample {
  @Test
  public void fooTest() {
    ITestResult r = Reporter.getCurrentTestResult();
    String methodname = r.getMethod().getMethodName();
    System.err.println(
        "Running " + methodname + "() on Thread [" + Thread.currentThread().getId() + "]");
  }
}
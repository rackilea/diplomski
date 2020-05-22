package com.rationaleemotions.stackoverflow.qn51160440;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformerImpl implements IAnnotationTransformer {

  @Override
  public void transform(
      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    //Pass the value via JVM argument -Dkvp=someMethod=400
    //Here "someMethod" is the name of the method and 400 is the invocation count value
    String kvp = System.getProperty("kvp", "fooTest=200");
    String keyValue[] = kvp.split("=");
    if (keyValue.length != 2) {
      return;
    }
    if (!testMethod.getName().equalsIgnoreCase(keyValue[0])) {
      return;
    }
    annotation.setInvocationCount(Integer.parseInt(keyValue[1]));
    annotation.setThreadPoolSize(25);
  }
}
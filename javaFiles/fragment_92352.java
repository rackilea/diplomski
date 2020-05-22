package test;

import java.util.Date;
import test.MyAnnotation;

@MyAnnotation
@SuppressWarnings("all")
public class MyAnnotationTest {
  public void generatedMethod() {
    Date date = new Date();
  }
}
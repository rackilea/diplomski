import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClassSample {

  @Test
  @SkipConfiguration
  public void foo() {}

  @Test
  public void bar() {}

  @AfterMethod
  public void teardown(Method method) {
    SkipConfiguration skip = method.getAnnotation(SkipConfiguration.class);
    if (skip != null) {
      System.err.println("Skipping tear down for " + method.getName());
      return;
    }
    System.err.println("Running tear down for " + method.getName());
  }
}
@MyCustomAnnotation(tags = "a", "supplemental")
public class A {
  ...
}

@MyCustomAnnotation(tags = "supplemental")
public class Supplemental {
  ...
}

public class MyInterceptor implements IMethodInterceptor {

  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    // for each method, if its class contains the expected tag, then add it to the list
    // expect tag can be passed by a system property or in a parameter from the suite file (available from ITestContext)
  }
}
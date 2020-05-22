public interface MyService {
  void doSomething();
}

public class MyServiceFactory {
  public static MyService getService() {
    try {
      (MyService) Class.forName(System.getProperty("MyServiceImplemetation")).newInstance();
    } catch (Throwable t) {
      throw new Error(t);
    }
  }
}
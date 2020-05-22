public class MyService {

  public MyService() {
    this(ResourceLoader.getInstance());
  }

  public MyService(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }
}
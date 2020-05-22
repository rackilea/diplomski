public class Builder {

  @Autowired
  private BaseServiceLocator baseServiceLocator;

  @Override
  public YourReturnType businessMethod() {
      SomeData data = getData();
      BaseService baseService = baseServiceLocator(data.getType()); //here I am assuming that getType() is a String

      //whatever
  }
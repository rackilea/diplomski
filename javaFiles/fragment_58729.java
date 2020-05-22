public class MyJson {
  private MyResponse response;
  ...
}

public class MyResponse {
  private List<MyClass> objects;
  ...
}

public class MyClass {
  String name;
  List<CustomProperty> customProperties;
  ...
}
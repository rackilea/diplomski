public MyClass {
  public static final MyClass[] instances;
  static {
    instances = new MyClass[1];
    instances[0] = new MyClass();
    instances[0].myField = "value1";
  }

  private String myField;
  public void doMethod()
  {
    ...
  }
}
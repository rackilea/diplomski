public class MyClass
{
  public static final MyClass[] instances;
  static {
    instances = new MyClass[1];
    instances[0] = new MyClass0();
    instances[0].myField = "value1";
  }
  ...
}
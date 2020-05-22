public interface MyInterface {
  public void update(String str);
}

public class Object1 implements MyInterface {
  @Override
  public void update(String str) {
  ...
  }
}

/// same for object 2 and 3

String[] string_list = {"foo", "bar", "barz"}
MyInterface[] obj_list = {Obj1, Obj2, Obj3}

...
...
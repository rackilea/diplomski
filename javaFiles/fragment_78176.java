package test;

import java.lang.reflect.Field;

public class Test {

  public static void main(String... args) throws Exception {
    Class<?> object = Class.forName("test.Property");
    Object o = object.getDeclaredConstructor().newInstance();
    System.out.println(o);
    Field testField = object.getDeclaredField("test");
    Field nameField = object.getDeclaredField("name");
    testField.setAccessible(true);
    testField.set(o, "Hello");
    testField.setAccessible(false);
    nameField.setAccessible(true);
    nameField.set(o, "Name");
    nameField.setAccessible(false);
    System.out.println(o);
  }

}

class Property {

  private String test;
  private String name;

  @Override
  public String toString() {
    return "Property{" + "test=" + (test == null ? "null" : test) + ", name=" + (name == null ? "null" : name) + '}';
  }
}
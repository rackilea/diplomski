public class MyClass {
    private static final Map<String, MyClass> values = new HashMap<>();

    public static final MyClass A = register(new MyClass("a"));
    public static final MyClass B = register(new MyClass("b"));
    public static final MyClass C = register(new MyClass("c"));

    private static MyClass register(MyClass instance) {
      values.put(instance.name, instance);
      return instance;
    }

    private MyClass(String name) {
      this.name = name;
    }
    // ...
}
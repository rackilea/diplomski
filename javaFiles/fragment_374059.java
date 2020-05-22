public class Test {
  // Deliberately chosing lowercase because it is a system attribute.
  interface immutable {
    // Nothing in here I can think of.
  }

  // immute - have I invented a new word?
  // What can I do with the return type to indicate immutability?
  public static <T> List<T> immute(List<T> list) {
    // If it's not an immutable
    if (!(list instanceof immutable)) {
      // Make it so - how can I stamp it so?
      return Hacker.hack(Collections.<T>unmodifiableList(list),
                         List.class,
                         immutable.class);
    }
    // It is immutable already - code DOES get here.
    return list;
  }

  public void test() {
    System.out.println("Hello");
    List<String> test = new ArrayList<>();
    test.add("Test");
    test("Test", test);
    List<String> immutableTest = immute(test);
    test("Immutable Test", immutableTest);
    List<String> immutableImmutableTest = immute(immutableTest);
    test("Immutable Immutable Test", immutableImmutableTest);
  }

  private void test(String name, Object o) {
    System.out.println(name + ":" + o.getClass().getSimpleName() + "=" + o);

  }

  public static void main(String args[]) {
    new Test().test();
  }
}

class Hacker {
  // Hack an object to seem to implement a new interface.
  // New interface should be instanceof testable.
  // Suggest the additional type is an empty interface.
  public static <T> T hack(final Object hack,
                           final Class<T> baseType,
                           final Class additionalType) {

    return (T) Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            new Class[]{baseType, additionalType},
            new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Always invoke the method in the hacked object.
        return method.invoke(hack, args);
      }
    });
  }
}
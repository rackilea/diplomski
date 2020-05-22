public class MockTest {
  public static void main(String[] args) {
    MockTest sandbox = Mockito.mock(MockTest.class);

    // gives a type safety warning suppressable with @SuppressWarnings
    verify(sandbox).exampleMethod(isA(Class.class), any(Foo.class));

    // gives an unchecked cast warning suppressable with @SuppressWarnings
    verify(sandbox).exampleMethod((Class<Foo>) isA(Class.class), any(Foo.class));

    // gives no warnings because the cast in the helper method below
    verify(sandbox).exampleMethod(isAClassOf(Foo.class), any(Foo.class));
  }

  @SuppressWarnings("unchecked")
  private static <T> Class<T> isAClassOf(Class<T> clazz) {
    return isA(Class.class);
  }

  <T extends Foo> void exampleMethod(Class<T> arg1, T arg2) { }
}
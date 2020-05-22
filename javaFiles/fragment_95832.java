interface Foo {
  int getSomething();
  void setSomethingElse(String somethingElse);
}

public class TestClass<T extends Foo> implements AbstractDataType<T> {
  T[] contents;

  public TestClass(int length) {
    this.contents = (T[])new Object[length];
  }

  public void doSomethingInteresting(int index, String str) {
    T obj = contents[index];
    System.out.println(obj.getSomething());
    obj.setSomethingElse(str);
  }
}
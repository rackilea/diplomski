class MyGenericClass<T extends Number> {
  public static MyGenericClass<Long> newInstance(Long value) {
    return new MyGenericClass<Long>(value);
  }

  public static MyGenericClass<Integer> newInstance(Integer value) {
    return new MyGenericClass<Integer>(value);
  }

  // hide constructor so you have to use factory methods
  private MyGenericClass(T value) {
    // implement the constructor
  }
  // ... implement the class
  public void frob(T number) {
    // do something with T
  }
}
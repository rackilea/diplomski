public <T> void someMethod() {
  GenericClass<T> obj1 = ... // has a value here
  GenericClass<T> obj2 = ... // has a value here

  obj1.setValue(obj2.getValue());
}
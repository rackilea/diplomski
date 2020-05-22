interface A<T> {

  T doSomething();
}

class ImplA implements A<SomethingElseA> {

  public SomethingElseA doSomething() {
    ...
  }
}

class ImplB implements A<SomethingElseB> {

  public SomethingElseB doSomething() {
    ...
  }
}
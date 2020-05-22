MyClass<String> stringMyClass = new MyClass<String>();
stringMyClass.addObserver(new StdoutObserver());


stringMyClass.update(new ObservableChange<MyClass<String>>() {
  @Override
  public void doChange(MyClass<String> observable) {
    observable.add("A");
    observable.add("B");
    observable.add("C");
    observable.add("D");
  }
});
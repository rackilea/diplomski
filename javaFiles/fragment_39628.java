final class MyClass {
  private final Dependency dependency;

  private MyClass(Dependency dependency) {
    this.dependency = dependency;
  }

  public static createInstance(Dependency dependency) {
    MyClass instance = new MyClass(dependency);
    dependency.addHandler(new Handler() {
      @Override void handle(int foo) { instance.doSomething(foo); }
    });
    instance.doSomething(0);
    return instance;
  }
  ...
}
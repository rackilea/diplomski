public class MyClass1 {
  doSomething() {
    myClass2();
  }

  //I want this method to return MyClass2 prototype
  @Autowired
  private ApplicationContext applicationContext;
  public MyClass2 myClass2() {
      return applicationContext.getBean(MyClass2.class);
  }
}
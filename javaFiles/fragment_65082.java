public MyClass(MyInterface myInterface) {}

  private MyInterface myInterface;
  ...
  public MyClass(MyInterface myInterface) {
    this.myInterface = myInterface;
  }

   public void doTest() {
       // do some processing
         ..
       // then delegate
      myInterface.doTest();
   }
}
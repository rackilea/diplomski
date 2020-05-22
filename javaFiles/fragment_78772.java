class MyClass {
   @Resource
   MyClass self;

   public void doSomething() {
       // This will NOT trigger the AOP associated with @SomeAnnotation
       this.doSomethingElse();

       // This will trigger the AOP associated with @SomeAnnotation
       self.doSomethingElse();
   }

   @SomeAnnotation
   public void doSomethingElse() {
       ...
   }
}
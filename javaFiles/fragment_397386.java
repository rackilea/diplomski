class MyClass {

   private final AnythingPerformerClass clazz;

   MyClass(AnythingPerformerClass clazz) {
      this.clazz = clazz;
   }

   public boolean performAnything() {         
     return clazz.doSomething();        
   }
}
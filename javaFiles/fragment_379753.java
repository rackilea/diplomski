class MyBar {

   private MyFoo myFoo;

   public MyBar(MyFoo myFoo) {
      this.myFoo = myFoo;
   }

   public void someMethod() {
      if (!myFoo.isBazz()) {
         myFoo.setBazz(true);
      } else {
         myFoo.startBazzer();
      }
   }
}
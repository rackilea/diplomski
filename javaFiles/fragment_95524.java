class A {

    public void doSomething(){
     B b = new B(this);
    }

    public void doSomethingElse(){
       // Do something wondrous
    }

}

Class B {

   private A par = null;
   public B(A parent){
      par = parent;
   }

   public void callMethodInParent(){
       par.doSomethingElse();
   }
}
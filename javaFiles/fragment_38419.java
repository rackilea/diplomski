class A {
   private String val;
   public String getVal() { return this.val }
   public void setVal(String newValue) { this.val = newValue }
}
class B extends A {
   // you already have access to getVal & setVal here, so it's useless to override them here
}
class C extends A {
   private String valCopy;

   @Override
   public void setVal(String newValue) {
      super(newValue);
      this.valCopy = newValue
      // new behavior so here it's ok to override
   }
}
IStrategy {
  public void fooToImplement();
} 

AClass {
   public AClass(IStrategy impl) {...}

    public void foo() {
      ...
      strategy.fooToImplement();
      ...
    }
}
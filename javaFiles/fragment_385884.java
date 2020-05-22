public SomeClass {
  private static String var1;
  private String var2;

  public void someMethod(){
     this.var2 // is allowed 
     this.var1 // is allowed
   }

   public static void someMethod(){
     this.var2 // is allowed 
     this.var1 // is not allowed
   }



}
class Example {
  Example();
    Code:
       0: aload_0       
       1: invokespecial #2                  // Method java/lang/Object."<init>":()V
       4: return   

  public static void main(java.lang.String[]);
    Code:
       0: iconst_1      
       1: newarray       int
       3: dup           
       4: iconst_0      
       5: iconst_2      
       6: iastore       
       7: astore_1      
       8: new           #3                  // class Example$1
      11: dup
      12: aload_1       
      13: invokespecial #4                  // Method Example$1."<init>":([I)V
      16: astore_2      
      17: return        

  static int[] access$000();
    Code:
       0: getstatic     #1                  // Field outside:[I
       3: areturn       

  static {};
    Code:
       0: iconst_1      
       1: newarray       int
       3: dup           
       4: iconst_0      
       5: iconst_1      
       6: iastore       
       7: putstatic     #1                  // Field outside:[I
      10: return        
}
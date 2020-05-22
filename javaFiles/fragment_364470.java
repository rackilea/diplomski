class InnerEx$1 implements java.lang.Runnable {
  final java.lang.String val$localVar;

  final InnerEx this$0;

  InnerEx$1(InnerEx, java.lang.String);
    Code:
       0: aload_0       
       1: aload_1       
       2: putfield      #1                  // Field this$0:LInnerEx;
       5: aload_0       
       6: aload_2       
       7: putfield      #2                  // Field val$localVar:Ljava/lang/String;
      10: aload_0       
      11: invokespecial #3                  // Method java/lang/Object."<init>":()V
      14: return        

  public void run();
    Code:
       0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: aload_0       
       4: getfield      #2                  // Field val$localVar:Ljava/lang/String;
       7: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      10: return        
}
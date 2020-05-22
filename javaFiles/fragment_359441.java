final class Example$1 {
  final int[] val$inside;

     Example$1(int[]);
        Code:
           0: aload_0       
           1: aload_1       
           2: putfield      #1                  // Field val$inside:[I
           5: aload_0       
           6: invokespecial #2                  // Method java/lang/Object."<init>":()V
           9: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
          12: invokestatic  #4                  // Method Example.access$000:()[I
          15: iconst_0      
          16: iaload        
          17: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
          20: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
          23: aload_0       
          24: getfield      #1                  // Field val$inside:[I
          27: iconst_0      
          28: iaload        
          29: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
          32: return        
    }
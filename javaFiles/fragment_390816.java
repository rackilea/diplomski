public static void a();
Code:
   0: iconst_0      
   1: istore_0      
   2: goto          15
   5: getstatic     #15                 // Field java/lang/System.out:Ljava/io/PrintStream;
   8: iload_0       
   9: invokevirtual #21                 // Method java/io/PrintStream.println:(I)V
  12: iinc          0, 1
  15: iload_0       
  16: bipush        10
  18: if_icmplt     5
  21: return        

public static void b();
Code:
   0: iconst_0      
   1: istore_0      
   2: goto          15
   5: getstatic     #15                 // Field java/lang/System.out:Ljava/io/PrintStream;
   8: iload_0       
   9: invokevirtual #21                 // Method java/io/PrintStream.println:(I)V
  12: iinc          0, 1
  15: iload_0       
  16: bipush        10
  18: if_icmplt     5
  21: return
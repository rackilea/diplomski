public static void main(java.lang.String[]) throws java.io.IOException;
Code:
   0: new           #19                 // class java/lang/StringBuilder
   3: dup
   4: invokespecial #21                 // Method java/lang/StringBuilder."<init>":()V
   7: astore_1
   8: new           #22                 // class java/lang/String
  11: dup
  12: invokespecial #24                 // Method java/lang/String."<init>":()V
  15: astore_2
  16: iconst_0
  17: istore_3
  18: goto          47
  21: new           #19                 // class java/lang/StringBuilder
  24: dup
  25: ldc           #25                 // String
  27: invokespecial #27                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
  30: iload_3
  31: invokevirtual #30                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  34: invokevirtual #34                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
  37: astore_2
  38: aload_1
  39: aload_2
  40: invokevirtual #38                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  43: pop
  44: iinc          3, 1
  47: iload_3
  48: sipush        1000
  51: if_icmplt     21
  54: return
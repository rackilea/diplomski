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
  18: goto          37
  21: aload_1
  22: bipush        32
  24: invokevirtual #25                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
  27: pop
  28: aload_1
  29: iload_3
  30: invokevirtual #29                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  33: pop
  34: iinc          3, 1
  37: iload_3
  38: sipush        1000
  41: if_icmplt     21
  44: return
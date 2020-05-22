public static void main(java.lang.String[]);
descriptor: ([Ljava/lang/String;)V
flags: (0x0009) ACC_PUBLIC, ACC_STATIC
Code:
  stack=2, locals=7, args_size=1
     0: iconst_3
     1: anewarray     #2        // class java/lang/String
     4: astore_1
     5: iconst_3
     6: istore_2
     7: aload_1
     8: astore_3
     9: aload_3
    10: arraylength
    11: istore        4
    13: iconst_0
    14: istore        5
    16: iload         5
    18: iload         4
    20: if_icmpge     43
    23: aload_3
    24: iload         5
    26: aaload
    27: astore        6
    29: getstatic     #3        // Field java/lang/System.out:Ljava/io/PrintStream;
    32: aload         6
    34: invokevirtual #4        // Method java/io/PrintStream.println:(Ljava/lang/String;)V
    37: iinc          5, 1
    40: goto          16
    43: return
  LocalVariableTable:
    Start  Length  Slot  Name   Signature
       29       8     6  name   Ljava/lang/String;
        0      44     0  args   [Ljava/lang/String;
        5      39     1 names   [Ljava/lang/String;
        7      37     2  var3   I
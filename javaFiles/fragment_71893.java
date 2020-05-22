private static java.lang.Integer lambda$main$0(java.lang.Integer);
   descriptor: (Ljava/lang/Integer;)Ljava/lang/Integer;
   flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
   Code:
     stack=2, locals=2, args_size=1
        0: aload_0
        1: invokevirtual #9                  // Method java/lang/Integer.intValue:()I
        4: iconst_1
        5: iadd
        6: invokestatic  #6                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        9: dup
       10: astore_0
       11: astore_1
       12: aload_0
       13: areturn
     LineNumberTable:
       line 20: 0
     LocalVariableTable:
       Start  Length  Slot  Name   Signature
           0      14     0     t   Ljava/lang/Integer;
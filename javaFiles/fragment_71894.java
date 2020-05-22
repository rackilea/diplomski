public java.lang.Integer get(java.lang.Integer);
    descriptor: (Ljava/lang/Integer;)Ljava/lang/Integer;
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=4, args_size=2
         0: aload_1
         1: astore_2
         2: aload_1
         3: invokevirtual #2                  // Method java/lang/Integer.intValue:()I
         6: iconst_1
         7: iadd
         8: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        11: dup
        12: astore_1
        13: astore_3
        14: aload_2
        15: areturn
      LineNumberTable:
        line 16: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      16     0  this   LTest$1;
            0      16     1     t   Ljava/lang/Integer;
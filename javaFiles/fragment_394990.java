private static java.lang.Integer lambda$main$0(java.lang.Integer, java.lang.Integer);
    descriptor: (Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;
    flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0       
         1: invokevirtual #17                 // Method java/lang/Integer.intValue:()I
         4: aload_1       
         5: invokevirtual #17                 // Method java/lang/Integer.intValue:()I
         8: imul          
         9: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        12: areturn       
      LineNumberTable:
        line 10: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      13     0     a   Ljava/lang/Integer;
            0      13     1     b   Ljava/lang/Integer;
}
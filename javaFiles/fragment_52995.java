public static void emptyStringConcatTest(int);
    flags: ACC_PUBLIC, ACC_STATIC
    LineNumberTable:
      line 27: 0
      line 28: 8
      line 29: 17
      line 31: 40
    Code:
      stack=2, locals=3, args_size=1
         0: new           #14                 // class java/lang/String
         3: dup
         4: invokespecial #15                 // Method java/lang/String."<init>":()V
         7: astore_1
         8: iload_0
         9: istore_2
        10: iload_2
        11: iinc          2, -1
        14: ifle          40
        17: new           #7                  // class java/lang/StringBuilder
        20: dup
        21: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
        24: aload_1
        25: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        28: ldc           #16                 // String
        30: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        33: invokevirtual #17                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        36: astore_1
        37: goto          10
        40: return
      LineNumberTable:
        line 27: 0
        line 28: 8
        line 29: 17
        line 31: 40
      StackMapTable: number_of_entries = 2
           frame_type = 253 /* append */
             offset_delta = 10
        locals = [ class java/lang/String, int ]
           frame_type = 250 /* chop */
          offset_delta = 29
java.lang.String joinWords(java.lang.String[]);
    Code:
       0: ldc           #2                  // String
       2: astore_2
       3: aload_1
       4: astore_3
       5: aload_3
       6: arraylength
       7: istore        4
       9: iconst_0
      10: istore        5
      12: iload         5
      14: iload         4
      16: if_icmpge     51
      19: aload_3
      20: iload         5
      22: aaload
      23: astore        6
      25: new           #3                  // class java/lang/StringBuilder
      28: dup
      29: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      32: aload_2
      33: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: aload         6
      38: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      41: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      44: astore_2
      45: iinc          5, 1
      48: goto          12
      51: aload_2
      52: areturn
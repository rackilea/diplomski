0: iload_0
       1: iload_2
       2: if_icmpne     14
       5: iload_1
       6: iload_2
       7: if_icmpeq     14
      10: iconst_1
      11: goto          15
      14: iconst_0
      15: istore_3
      16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: iload_3
      20: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
      23: return
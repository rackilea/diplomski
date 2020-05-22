public void run();
    Code:
       0: iconst_0
       1: istore_1
       2: iconst_0
       3: istore_2
       4: iload_2
       5: ldc           #2                  // int 2147483647
       7: if_icmpge     19
      10: iinc          1, 1
      13: iinc          2, 1
      16: goto          4
      19: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      22: iload_1
      23: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      26: return
}
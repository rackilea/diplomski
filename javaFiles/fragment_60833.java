public void run();
    Code:
       0: iconst_0
       1: istore_1
       2: lconst_0
       3: lstore_2
       4: lload_2
       5: ldc2_w        #2                  // long 2147483647l
       8: lcmp
       9: ifge          22
      12: iinc          1, 1
      15: lload_2
      16: lconst_1
      17: ladd
      18: lstore_2
      19: goto          4
      22: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      25: iload_1
      26: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
      29: return
}
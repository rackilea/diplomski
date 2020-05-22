public static long iteration_fib(int);
  Code:
   0:   lconst_1
   1:   lstore_1
   2:   lconst_1
   3:   lstore_3
   4:   iload_0
   5:   iinc    0, -1
   8:   iconst_2
   9:   if_icmple       25
   12:  lload_3
   13:  lstore  5
   15:  lload_3
   16:  lload_1
   17:  ladd
   18:  lstore_3
   19:  lload   5
   21:  lstore_1
   22:  goto    4
   25:  lload_3
   26:  lreturn

public static long recursive_fib(int);
  Code:
   0:   iload_0
   1:   iconst_2
   2:   if_icmpgt       7
   5:   lconst_1
   6:   lreturn
   7:   iload_0
   8:   iconst_1
   9:   isub
   10:  invokestatic    #13; //Method recursive_fib:(I)J
   13:  iload_0
   14:  iconst_2
   15:  isub
   16:  invokestatic    #13; //Method recursive_fib:(I)J
   19:  ladd
   20:  lreturn
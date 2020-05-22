public int foo(int, int);
  Code:
   0:   goto    10
   3:   iload_2
   4:   iinc    2, 1
   7:   iload_1
   8:   idiv
   9:   istore_1
   10:  iload_1
   11:  iload_2
   12:  if_icmplt   3
   15:  goto    25
   18:  astore_3
   19:  bipush  10
   21:  istore_1
   22:  goto    10
   25:  iload_2
   26:  ireturn
  Exception table:
   from   to  target type
     0    15    18   Class java/lang/RuntimeException
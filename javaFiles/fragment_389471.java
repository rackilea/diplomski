public void foo();
  Code:
   0:   iconst_0
   1:   istore_1
   2:   goto    28
   5:   iconst_0
   6:   istore_2
   7:   goto    20
   10:  getstatic   #25; //Field java/lang/System.out:Ljava/io/PrintStream;
   13:  iload_2
   14:  invokevirtual   #31; //Method java/io/PrintStream.println:(I)V
   17:  iinc    2, 1
   20:  iload_2
   21:  iconst_5
   22:  if_icmplt   10
   25:  iinc    1, 1
   28:  iload_1
   29:  iconst_2
   30:  if_icmplt   5
   33:  return
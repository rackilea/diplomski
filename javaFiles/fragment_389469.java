public void foo2();
  Code:
   0:   iconst_0
   1:   istore_1
   2:   goto    15
   5:   getstatic   #25; //Field java/lang/System.out:Ljava/io/PrintStream;
   8:   iload_1
   9:   invokevirtual   #31; //Method java/io/PrintStream.println:(I)V
   12:  iinc    1, 1
   15:  iload_1
   16:  iconst_5
   17:  if_icmplt   5
   20:  return
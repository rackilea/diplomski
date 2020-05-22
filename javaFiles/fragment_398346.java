public static boolean check(Test$MyObject, java.util.List);
  Code:
   0:   aload_0
   1:   getfield        #7; //Field Test$MyObject.p:I
   4:   istore_2
   5:   iconst_0
   6:   istore_3
   7:   iload_3
   8:   ldc     #4; //int 1000000
   10:  if_icmpge       42
   13:  aload_1
   14:  iload_3
   15:  invokeinterface #11,  2; //InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
   20:  checkcast       #5; //class Test$MyObject
   23:  astore  4
   25:  aload   4
   27:  getfield        #7; //Field Test$MyObject.p:I
   30:  iload_2
   31:  if_icmpge       36
   34:  iconst_0
   35:  ireturn
   36:  iinc    3, 1
   39:  goto    7
   42:  iconst_1
   43:  ireturn
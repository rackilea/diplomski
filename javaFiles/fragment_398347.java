public static boolean check(Test$MyObject, java.util.List);
  Code:
   0:   iconst_0
   1:   istore_2
   2:   iload_2
   3:   ldc     #4; //int 1000000
   5:   if_icmpge       38
   8:   aload_1
   9:   iload_2
   10:  invokeinterface #11,  2; //InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
   15:  checkcast       #5; //class Test$MyObject
   18:  astore_3
   19:  aload_3
   20:  getfield        #7; //Field Test$MyObject.p:I
   23:  aload_0
   24:  getfield        #7; //Field Test$MyObject.p:I
   27:  if_icmpge       32
   30:  iconst_0
   31:  ireturn
   32:  iinc    2, 1
   35:  goto    2
   38:  iconst_1
   39:  ireturn
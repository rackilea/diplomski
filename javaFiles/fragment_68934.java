0: aload_2
   1: invokestatic  #2                  // Method java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
   4: pop
   5: aload_0
   6: aload_1
   7: invokevirtual #3                  // Method get:(Ljava/lang/Object;)Ljava/lang/Object;
  10: astore_3
  11: aload_3
  12: ifnonnull     40
  15: aload_2
  16: aload_1
  17: invokeinterface #4,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
  22: astore        4
  24: aload         4
  26: ifnull        40
  29: aload_0
  30: aload_1
  31: aload         4
  33: invokevirtual #5                  // Method put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
  36: pop
  37: aload         4
  39: areturn
  40: aload_3
  41: areturn
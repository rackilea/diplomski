0: aload_2
   1: invokestatic  #2                  // Method java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
   4: pop
   5: aload_0
   6: aload_1
   7: invokevirtual #3                  // Method get:(Ljava/lang/Object;)Ljava/lang/Object;
  10: dup
  11: astore_3
  12: ifnonnull     39
  15: aload_2
  16: aload_1
  17: invokeinterface #4,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
  22: dup
  23: astore        4
  25: ifnull        39
  28: aload_0
  29: aload_1
  30: aload         4
  32: invokevirtual #5                  // Method put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
  35: pop
  36: aload         4
  38: areturn
  39: aload_3
  40: areturn
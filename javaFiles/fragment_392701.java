L2
        LINENUMBER 35 L2
        ALOAD 1
        ALOAD 2
        INVOKEDYNAMIC get(Lcom/sun/tools/javac/util/Pair;Ljava/lang/Integer;)Ljava/util/function/Supplier; [
          // handle kind 0x6 : INVOKESTATIC
          java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
          // arguments:
          ()Ljava/lang/Object;, 
          // handle kind 0x6 : INVOKESTATIC
          com/sfl/stackoverflow/LambdasExperiment.lambda$performLambdasDemo$1(Lcom/sun/tools/javac/util/Pair;Ljava/lang/Integer;)Ljava/lang/Integer;, 
          ()Ljava/lang/Integer;
        ]
        ASTORE 3
       L3
    // Omit quite some byte-code and jump to the method declaration
    // access flags 0x100A
      private static synthetic lambda$performLambdasDemo$1(Lcom/sun/tools/javac/util/Pair;Ljava/lang/Integer;)Ljava/lang/Integer;
       L0
        LINENUMBER 36 L0
        ALOAD 0
        GETFIELD com/sun/tools/javac/util/Pair.fst : Ljava/lang/Object;
        CHECKCAST java/lang/Integer
        INVOKEVIRTUAL java/lang/Integer.intValue ()I
        SIPUSH 9000
        IADD
        ALOAD 1
        INVOKEVIRTUAL java/lang/Integer.intValue ()I
        IADD
        INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;
        ARETURN
        MAXSTACK = 2
        MAXLOCALS = 2
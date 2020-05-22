static {};
    Code:
       0: invokestatic  #23                 // Method $getCallSiteArray:()[Lorg/codehaus/groovy/runtime/callsite/CallSite;
       3: ldc           #89                 // int 1
       5: aaload
       6: ldc           #91                 // class org/slf4j/LoggerFactory
       8: invokestatic  #23                 // Method $getCallSiteArray:()[Lorg/codehaus/groovy/runtime/callsite/CallSite;
      11: ldc           #92                 // int 2
      13: aaload
      14: ldc           #2                  // class ClassWithLog
      16: invokeinterface #96,  2           // InterfaceMethod org/codehaus/groovy/runtime/callsite/CallSite.callStatic:(Ljava/lang/Class;)Ljava/lang/Object;
      21: invokeinterface #44,  3           // InterfaceMethod org/codehaus/groovy/runtime/callsite/CallSite.call:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      26: astore_0
      27: aload_0
      28: ldc           #98                 // class org/slf4j/Logger
      30: invokestatic  #102                // Method org/codehaus/groovy/runtime/ScriptBytecodeAdapter.castToType:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      33: checkcast     #98                 // class org/slf4j/Logger
      36: putstatic     #36                 // Field LOG:Lorg/slf4j/Logger;
      39: aload_0
      40: pop
      41: return
    LineNumberTable:
      line 6: 0
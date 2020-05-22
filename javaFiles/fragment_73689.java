public final class com.sun.proxy.$Proxy0 extends java.lang.reflect.Proxy implements java.lang.Runnable {
  private static java.lang.reflect.Method m1;

  private static java.lang.reflect.Method m3;

  private static java.lang.reflect.Method m0;

  private static java.lang.reflect.Method m2;

  public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler);
    Code:
       0: aload_0       
       1: aload_1       
       2: invokespecial #8                  // Method java/lang/reflect/Proxy."<init>":(Ljava/lang/reflect/InvocationHandler;)V
       5: return        

  public final int hashCode();
    Code:
       0: aload_0       
       1: getfield      #16                 // Field java/lang/reflect/Proxy.h:Ljava/lang/reflect/InvocationHandler;
       4: aload_0       
       5: getstatic     #55                 // Field m0:Ljava/lang/reflect/Method;
       8: aconst_null   
       9: invokeinterface #28,  4           // InterfaceMethod java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
      14: checkcast     #57                 // class java/lang/Integer
      17: invokevirtual #60                 // Method java/lang/Integer.intValue:()I
      20: ireturn       
      21: athrow        
      22: astore_1      
      23: new           #42                 // class java/lang/reflect/UndeclaredThrowableException
      26: dup           
      27: aload_1       
      28: invokespecial #45                 // Method java/lang/reflect/UndeclaredThrowableException."<init>":(Ljava/lang/Throwable;)V
      31: athrow        
    Exception table:
       from    to  target type
           0    21    21   Class java/lang/Error
           0    21    21   Class java/lang/RuntimeException
           0    21    22   Class java/lang/Throwable

  public final boolean equals(java.lang.Object);
    Code:
       0: aload_0       
       1: getfield      #16                 // Field java/lang/reflect/Proxy.h:Ljava/lang/reflect/InvocationHandler;
       4: aload_0       
       5: getstatic     #20                 // Field m1:Ljava/lang/reflect/Method;
       8: iconst_1      
       9: anewarray     #22                 // class java/lang/Object
      12: dup           
      13: iconst_0      
      14: aload_1       
      15: aastore       
      16: invokeinterface #28,  4           // InterfaceMethod java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
      21: checkcast     #30                 // class java/lang/Boolean
      24: invokevirtual #34                 // Method java/lang/Boolean.booleanValue:()Z
      27: ireturn       
      28: athrow        
      29: astore_2      
      30: new           #42                 // class java/lang/reflect/UndeclaredThrowableException
      33: dup           
      34: aload_2       
      35: invokespecial #45                 // Method java/lang/reflect/UndeclaredThrowableException."<init>":(Ljava/lang/Throwable;)V
      38: athrow        
    Exception table:
       from    to  target type
           0    28    28   Class java/lang/Error
           0    28    28   Class java/lang/RuntimeException
           0    28    29   Class java/lang/Throwable

  public final java.lang.String toString();
    Code:
       0: aload_0       
       1: getfield      #16                 // Field java/lang/reflect/Proxy.h:Ljava/lang/reflect/InvocationHandler;
       4: aload_0       
       5: getstatic     #65                 // Field m2:Ljava/lang/reflect/Method;
       8: aconst_null   
       9: invokeinterface #28,  4           // InterfaceMethod java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
      14: checkcast     #67                 // class java/lang/String
      17: areturn       
      18: athrow        
      19: astore_1      
      20: new           #42                 // class java/lang/reflect/UndeclaredThrowableException
      23: dup           
      24: aload_1       
      25: invokespecial #45                 // Method java/lang/reflect/UndeclaredThrowableException."<init>":(Ljava/lang/Throwable;)V
      28: athrow        
    Exception table:
       from    to  target type
           0    18    18   Class java/lang/Error
           0    18    18   Class java/lang/RuntimeException
           0    18    19   Class java/lang/Throwable

  static {};
    Code:
       0: ldc           #70                 // String java.lang.Object
       2: invokestatic  #76                 // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
       5: ldc           #77                 // String equals
       7: iconst_1      
       8: anewarray     #72                 // class java/lang/Class
      11: dup           
      12: iconst_0      
      13: ldc           #70                 // String java.lang.Object
      15: invokestatic  #76                 // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
      18: aastore       
      19: invokevirtual #81                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      22: putstatic     #20                 // Field m1:Ljava/lang/reflect/Method;
      25: ldc           #83                 // String java.lang.Runnable
      27: invokestatic  #76                 // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
      30: ldc           #84                 // String run
      32: iconst_0      
      33: anewarray     #72                 // class java/lang/Class
      36: invokevirtual #81                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      39: putstatic     #50                 // Field m3:Ljava/lang/reflect/Method;
      42: ldc           #70                 // String java.lang.Object
      44: invokestatic  #76                 // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
      47: ldc           #85                 // String hashCode
      49: iconst_0      
      50: anewarray     #72                 // class java/lang/Class
      53: invokevirtual #81                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      56: putstatic     #55                 // Field m0:Ljava/lang/reflect/Method;
      59: ldc           #70                 // String java.lang.Object
      61: invokestatic  #76                 // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
      64: ldc           #86                 // String toString
      66: iconst_0      
      67: anewarray     #72                 // class java/lang/Class
      70: invokevirtual #81                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      73: putstatic     #65                 // Field m2:Ljava/lang/reflect/Method;
      76: return        
      77: astore_1      
      78: new           #90                 // class java/lang/NoSuchMethodError
      81: dup           
      82: aload_1       
      83: invokevirtual #93                 // Method java/lang/Throwable.getMessage:()Ljava/lang/String;
      86: invokespecial #96                 // Method java/lang/NoSuchMethodError."<init>":(Ljava/lang/String;)V
      89: athrow        
      90: astore_1      
      91: new           #100                // class java/lang/NoClassDefFoundError
      94: dup           
      95: aload_1       
      96: invokevirtual #93                 // Method java/lang/Throwable.getMessage:()Ljava/lang/String;
      99: invokespecial #101                // Method java/lang/NoClassDefFoundError."<init>":(Ljava/lang/String;)V
     102: athrow        
    Exception table:
       from    to  target type
           0    77    77   Class java/lang/NoSuchMethodException
           0    77    90   Class java/lang/ClassNotFoundException

  public final void run();
    Code:
       0: aload_0       
       1: getfield      #16                 // Field java/lang/reflect/Proxy.h:Ljava/lang/reflect/InvocationHandler;
       4: aload_0       
       5: getstatic     #50                 // Field m3:Ljava/lang/reflect/Method;
       8: aconst_null   
       9: invokeinterface #28,  4           // InterfaceMethod java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
      14: pop           
      15: return        
      16: athrow        
      17: astore_1      
      18: new           #42                 // class java/lang/reflect/UndeclaredThrowableException
      21: dup           
      22: aload_1       
      23: invokespecial #45                 // Method java/lang/reflect/UndeclaredThrowableException."<init>":(Ljava/lang/Throwable;)V
      26: athrow        
    Exception table:
       from    to  target type
           0    16    16   Class java/lang/Error
           0    16    16   Class java/lang/RuntimeException
           0    16    17   Class java/lang/Throwable
}
$ javap -c B
Compiled from "B.java"
interface B extends A {
  public abstract B setX(java.lang.Object);

  public A setX(java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: invokeinterface #1,  2          // InterfaceMethod     setX:(Ljava/lang/Object;)LB;
       7: areturn
}
✗ javac Question14640184.java
✗ javap -c Question14640184
Compiled from "Question14640184.java"
public class com.stackoverflow.Question14640184 extends java.lang.Object{
public com.stackoverflow.Question14640184();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public void enhancedForLoop(java.lang.Iterable, java.lang.Iterable);
  Code:
   0:   aload_1
   1:   invokeinterface #2,  1; //InterfaceMethod java/lang/Iterable.iterator:()Ljava/util/Iterator;
   6:   astore_3
   7:   aload_3
   8:   invokeinterface #3,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   13:  ifeq    57
   16:  aload_3
   17:  invokeinterface #4,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   22:  astore  4
   24:  aload_2
   25:  invokeinterface #2,  1; //InterfaceMethod java/lang/Iterable.iterator:()Ljava/util/Iterator;
   30:  astore  5
   32:  aload   5
   34:  invokeinterface #3,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   39:  ifeq    54
   42:  aload   5
   44:  invokeinterface #4,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   49:  astore  6
   51:  goto    32
   54:  goto    7
   57:  return

public void iteratorForLoop(java.lang.Iterable, java.lang.Iterable);
  Code:
   0:   aload_1
   1:   invokeinterface #2,  1; //InterfaceMethod java/lang/Iterable.iterator:()Ljava/util/Iterator;
   6:   astore_3
   7:   aload_3
   8:   invokeinterface #3,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   13:  ifeq    57
   16:  aload_3
   17:  invokeinterface #4,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   22:  astore  4
   24:  aload_2
   25:  invokeinterface #2,  1; //InterfaceMethod java/lang/Iterable.iterator:()Ljava/util/Iterator;
   30:  astore  5
   32:  aload   5
   34:  invokeinterface #3,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   39:
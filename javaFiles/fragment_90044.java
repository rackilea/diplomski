$ javap -c Sample.class
  ...
  public static void main(java.lang.String[]) throws java.io.IOException;
    Code:
       0: invokestatic  #19                 // Method java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
       3: ldc           #25                 // String echo 'test' > test.txt
       5: invokevirtual #27                 // Method java/lang/Runtime.exec:(Ljava/lang/String;)Ljava/lang/Process;
       8: pop
       9: return
public class Example {
  // ...omitted constructor stuff...

  public static final void main(java.lang.String[]);
    Code:
      // The `int i = 5;` line:
       0: iconst_5               // Load the constant 5 onto the stack
       1: istore_1               // Store it in local variable 1

      // The `System.out.println(i);` line:
       2: getstatic     #2       // Get the static field java/lang/System.out:Ljava/io/PrintStream onto the stack
       5: iload_1                // Load int variable 1 on the stack
       6: invokevirtual #3       // Call java/io/PrintStream.println, which gets
                                 // the stream and what to write from the stack
       9: return
}
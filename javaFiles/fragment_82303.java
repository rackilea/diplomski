public class Example {
  // Here's the instance field
  int i;

  // ...omitted the constructor stuff...

  public static final void main(java.lang.String[]);
    Code:
      // Create our Example instance and save it in a local variable
       0: new           #3
       3: dup
       4: invokespecial #4
       7: astore_1

      // The `System.out.println(ex.i)` line:
       8: getstatic     #5     // Get the java/lang/System.out:Ljava/io/PrintStream field
      11: aload_1              // Get `ex` onto the stack
      12: getfield      #2     // Get the value of field `i` onto the stack from the instance we just put on the stack (pops the instance off)
      15: invokevirtual #6     // Call java/io/PrintStream.println, which
                               // again gets the stream to write to and
                               // what to write from the stack
      18: return
}
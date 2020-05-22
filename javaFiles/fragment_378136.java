public class MyFilterPrintStream extends PrintStream {
  @Override public void print(String s) {
    // ... process output string here ...

    // pass along to actual console output
    super.print(s);
  }
}

// install my filter 
System.setOut(new MyFilterPrintStream(System.out));
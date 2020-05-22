public static void main(String[] args) {
  try {
     ... // your original code
  } catch (Throwable t) {
     // log the exception 
    t.printStacktrace(); // or use your logging framework 
    System.exit(1); 
  }
}
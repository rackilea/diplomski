class MyClass {
   public void readFile() {
    // ... some logic
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("P1.txt");
    // ... some logic with the stream.
   }
}
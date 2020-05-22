class MyClass {
  public void outputTo(PrintWriter w) {
    String text = ...
    w.println(text);
  }
}

and you use it like this:

try (FileOutputStream fos = new FileOutputStream("filename", append);
     PrintWriter w = new PrintWriter(fos)) {
  new MyClass().outputTo(w); // first instance
  new MyClass().outputTo(w); // second instance
  //... etc.
}
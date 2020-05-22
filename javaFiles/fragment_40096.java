public class Class {
  // instance variable  
  private int x; // <-- This variable is NOT final.

  public Class() {
    // initialise instance variables
    final int x = 123; // <-- This is NOT the instance variable x, but rather hiding this.x with a method local variable called 'x'
  }

  public void sampleMethod() {
    // trying to change it using final again
    final int x = 257; // <-- This is NOT the instance variable x, but rather hiding this.x with a method local variable called 'x'
    System.out.println(x);
    System.out.println(this.x); // see!

  }
  public void sampleMethod2() {
    // trying to change it using without using final
    x = 999; // This changes this.x, but this.x IS NOT final.
    System.out.println(x);
  }
}
package recipeNo001;

public class HelloWorld {

  static {
    System.loadLibrary("HelloWorld");
  }

  private native void displayMessage();

  static class NativeWrapper {
    void callNative() {
      displayMessageInner();
    }
    private native void displayMessageInner();
  }

  public static void main(String[] args) {
    new HelloWorld().displayMessage();
    new NativeWrapper().callNative();
  }
}
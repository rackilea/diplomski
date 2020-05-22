public class Test extends Observer {
  @Override
  public void frobination() {
    System.out.println("go go gadget frobinator");
  }

  public static void main(String[] argv) {
    System.loadLibrary("mymodule");
    Test t = new Test();
    MyModule.bar(t);    
  }
}
public class MyClass {

  public static void main(String[] args) {
    if (args.length > 0) {
      File file = new File(args[0]);
      System.out.println("My file is " + file.getPath());
    }
  }

}
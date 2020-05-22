public class DesktopPrinter implements Printer {
  public void print(String s) {
    System.out.println(s);
  }
}


public class AndroidPrinter implements Printer {
  public void print(String s) {
    Log.d("MyApp", s);
  }
}
//on desktop, use System.out.println()
public class DesktopPrinter implements Printer{
   public void print(String printMe){
      System.out.println(printMe);
   }
}

//on desktop, entry point is main()
public class DesktopMain{
   public static void main(String... args){
      DesktopPrinter printer = new DesktopPrinter();
      CoreAdder adder = new CoreAdder(printer);
      adder.addAndPrint(1, 2);
   }
}
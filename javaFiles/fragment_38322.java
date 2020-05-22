//example core class
public class CoreAdder{

   Printer printer;

   public CoreAdder(Printer printer){
      this.printer = printer;
   }

   public void addAndPrint(int x, int y){
      int sum = x+y;
      printer.print("Sum: " + sum);
   }
}

//example core interface. We might print differently on
//Android and Desktop, so implement this interface in each.
public interface Printer{
   public void print(String printMe);
}
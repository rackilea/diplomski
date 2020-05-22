import java.lang.reflect.Method;
import java.util.Scanner;

public class FieldResolutionTest {
     public static void main (String[] args) throws Exception {
         Scanner inputScanner = new Scanner(System.in);
         MethodTester test = new MethodTester();

         System.out.println("Please enter ONE or TWO");
         String selection = inputScanner.nextLine();

         Method method = MethodTester.class.getMethod(selection);
         method.invoke(test);
     }
}

class MethodTester {
     public void ONE() {
         System.out.println("You ran method ONE");
     }

     public void TWO() {
         System.out.println("You ran method TWO");
     }
}
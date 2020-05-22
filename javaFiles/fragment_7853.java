import java.lang.reflect.Field;
import java.util.Scanner;

public class VariableInput {
   public static class Input {
     public int a;
     public int b;
     public int c;
   }

   public static void main(String[] args) throws IllegalArgumentException,
       IllegalAccessException {
      Scanner keysIn = new Scanner(System.in);
      Field[] fields = Input.class.getDeclaredFields();
      Input in = new Input();
      for (int i = 0; i < 3; i++) {
         System.out.printf("Enter value for %s: ", fields[i].getName());
         fields[i].set(in, keysIn.nextInt());
      }
      int d = in.a + in.b + in.c;
      System.out.println("d=" + d);
   }
}
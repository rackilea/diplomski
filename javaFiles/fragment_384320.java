public class Example_1 {
    public static void main(String args[]) {

      int x = 0;
      int y = 1;
      int z;
      int sum = 0;

      while (true) {
          z = x + y;
          x = y;
          y = z;
          if(y % 2 == 0) {
             sum = sum + y;
          }
          if (sum >= 4000000){
              break;
          }
      }
      System.out.println("Sum: " + sum);
  }
}
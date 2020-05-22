import java.math.BigDecimal;
import java.util.Scanner;


public class home {

public static void main(String[] args) {
  Scanner scan = new Scanner(System.in); 
  BigDecimal bg1 = scan.nextBigDecimal();
  BigDecimal bg2 = scan.nextBigDecimal();

  System.out.println("Result is " + bg1.add(bg2));
 } 
}
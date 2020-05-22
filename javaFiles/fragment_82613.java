import java.util.Scanner;

public class Work {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    double a, b, c, d;
    System.out.print("Enter the first number: ");
    a = scan.nextDouble();

    System.out.print("Enter the second number: ");
    b = scan.nextDouble();

    /* various calculations  */
    c = a / b;
    d = b / a;


    if (b != 0)
    {
      System.out.printf("a/b = %.2f\n", c); /* the dominator (b) is not
                                             zero, so the solution is a/b
                                             (stored in the variable c) */
    }
    else
    {
      System.out.print("a/b = INF\n"); /* the dominator (b) is zero, 
                                        so the solution is INF */
    }

    if (a != 0)
    {  
      System.out.print("b/a = %.2f\n", d); /* the dominator (a) is not
                                            zero, so the solution is a/b
                                            (stored in the variable d) */
    }
    else
    {  
      System.out.printf("b/a = INF\n"); /* the dominator (a) is zero, 
                                         so the solution is INF */
    }
  }
}
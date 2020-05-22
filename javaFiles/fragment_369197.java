import java.math.*;

public class a
{
  public static void printNeighbours(BigDecimal start)
  {
    double result1 = start.doubleValue();
    double result2;

    BigDecimal r1 = new BigDecimal(result1);

    int com = start.compareTo(r1);

    if(com != 0)
      result2 = Math.nextAfter(result1, com * Double.MAX_VALUE);
    else
    {
      result2 = Math.nextAfter(result1, Double.MAX_VALUE);
      result1 = Math.nextAfter(result1, -Double.MAX_VALUE);
      r1 = new BigDecimal(result1);
    }

    BigDecimal r2 = new BigDecimal(result2);

    System.out.println("starting:\t"+start);

    if(com<0)
    {
      System.out.println("smaller:\t" + r2);        
      System.out.println("bigger:\t\t"+r1);
    }
    else
    {
      System.out.println("smaller:\t" + r1);        
      System.out.println("bigger:\t\t"+r2);
    }

    System.out.println();
  }

  public static void main(String[] args)
  {
    printNeighbours(new BigDecimal("0.25"));
    printNeighbours(new BigDecimal("0.1"));
    printNeighbours(new BigDecimal("0.7"));
  }
}
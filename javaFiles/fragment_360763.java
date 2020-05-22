public class Test {

  private static java.text.DecimalFormat sf = new java.text.DecimalFormat("0.##E0");

  public static void main(String[] args) {
    System.out.println(sf.format(Double.parseDouble("3.4213946120686956E-9")));
  }
};
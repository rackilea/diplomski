public class Test {

  public static void main(String[] args) {
    test(0);
    test(179);
    test(180);
    test(181.0001);
    test(359);
    test(360.0001);
    test(180+360);
  }

  private static void test(double angle){
    System.out.println("Raw angle: "+angle+" modded: "+modAngle(angle));
  }

  private static double modAngle(double angle) {
    if ((int) (angle / 180.0) % 2 != 0) {
      return 0;
    } else {
      return angle;
    }
  }
}
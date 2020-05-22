public strictfp class Test {
  public static void main(String[] args) {
    double in[] = {1e10, Math.nextUp(1e10)};
    double target = 2e10;
    System.out.println(in[0]+in[1]);
    double diff = target-in[0];
    System.out.println(diff);
    System.out.println(in[1] == diff);
    System.out.println(in[0]+in[1] == target);
  }
}
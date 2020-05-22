public static void main(String[] args) {
    System.out.println("  =      =      <      <=    >=      >");
    System.out.println("First  Last   Lower  Floor Ceiling Higher  Input");
    test();
    test(1,1,1,1,1,9,9,9,9,9);
    test(1,1,1,5,5,5,9,9,9,9);
    test(1,1,1,1,1,1,1,1,1,1);
    test(5,5,5,5,5,5,5,5,5,5);
    test(9,9,9,9,9,9,9,9,9,9);
    test(0,1,2,3,4,5,6,7,8,9);
    System.out.printf("%nStats: min=%d, max=%d, avg=%s%n",
                      minComp, maxComp, countComp / (double) countSearch);
}
private static void test(int... a) {
    System.out.printf("%3d%7d%7d%7d%7d%7d     %s%n",
                      binaryFirst(a, 5), binaryLast(a, 5), binaryLower(a, 5),
                      binaryFloor(a, 5), binaryCeiling(a, 5), binaryHigher(a, 5),
                      Arrays.toString(a));
}
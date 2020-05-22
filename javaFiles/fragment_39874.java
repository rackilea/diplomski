public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    double res = 0;
    for (int i = 0; i < 100000000; i++) {
        res = DoubleCalcTest();
    }

    System.out.println(res);
    long endTime = System.currentTimeMillis();
    System.out.println("That took " + (endTime - startTime) + " milliseconds");
}
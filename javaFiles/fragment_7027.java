public static void printCommonLogTable() {
    double x = 0.0;
    while (x <= 10.0) {
        System.out.println(x + "   " + Math.log(x) + "   ");
        x = x + 0.5;
    }
}
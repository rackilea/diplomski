public static void printCommonLogTable() {
    double x = 0.0;
    while (x <= 10.0) {
        System.out.print(x + "   " + Math.log(x) + "   ");
        x = x + 0.5;
        System.out.println();
    }
}
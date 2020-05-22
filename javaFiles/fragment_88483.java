public static void hexconverter(int a) {
    if (a == 0) {
        System.out.println();
    } else {
        System.out.print(hexchart(a % 16));
        hexconverter(a / 16);
    }
}
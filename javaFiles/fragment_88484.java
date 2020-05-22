public static void hexconverter(int a) {
    if (a == 0) {
        System.out.println();
    } else {
        hexconverter(a / 16);
        System.out.print(hexchart(a % 16));
    }
}
public static void test(int start, int end) {
    int current = start;
    int stepWidth = current <= end ? +1 : -1;
    while (current != (end + stepWidth)) {
        System.out.print(current + "\t");
        current += stepWidth;
    }
    System.out.println("");
}
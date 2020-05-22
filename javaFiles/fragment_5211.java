public static void test(int start, int end) {
    int stepWidth = start <= end ? 1 : -1;
    for (int current = start; current != end + stepWidth; current += stepWidth) {
        System.out.print(current + "\t");
    }
    System.out.println("");
}
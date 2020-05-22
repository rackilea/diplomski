public static void decToBin(int num) {
    if (num > 0) {
        decToBin(num / 2);
        System.out.print(num % 2);
    }
}
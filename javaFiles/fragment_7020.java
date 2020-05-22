public static void decToBin(int num) {
    if (num > 0) {
        System.out.print(num % 2);
        decToBin(num / 2);
    }
}
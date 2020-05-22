for (int m : money) {
    int largest = Integer.MIN_VALUE;
    for (int p : price) {
        if (p > largest && p <= m) {
            largest = p;
        }
    }
    System.out.print(largest + " ");
}
for (int i = 1; i < 10000; i++) {
    if (isAmicable(i)) {
        System.out.println("i = " + i);
        total += i;
    }
}
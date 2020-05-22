for (int i = 1; i < 10000; i++) {
    for (int j = 1; j < 10000; j++) {
        if (isAmicablePair(i, j)) {
            System.out.println("(i, j) = (" + i + ", " + j + ")");
            total += (i + j);
        }
    }
}
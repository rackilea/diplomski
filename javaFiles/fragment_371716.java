for (int i = 0; i < n; i++) {
    int maxIndex = -1;           // remove these variable declarations from top of method
    int max = Integer.MIN_VALUE; // it's best to confine variables to narrow scope
    for (int j = 0; j < k; j++) {
        if (!Li[j].isEmpty()) {
            int current = Li[j].extractMax();
            if (maxIndex == -1 || current > max) {
                maxIndex = j;
                max = current;
            }
        }
    }
    assert maxIndex != -1;
    Li[maxIndex].deleteMax();
    System.out.print(max + " ");
}
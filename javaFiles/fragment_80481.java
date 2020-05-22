public static void main(String[] args) {
    final int methods = 4;
    final int[] input = new int[0]; // or whatever you want.
    final long[] measures = new long[methods];

    for (int c = 0; c < methods; c++) {
        int[] copy = new int[input.length];
        System.arraycopy(input, 0, copy, 0, input.length);

        long start = System.nanoTime();
        switch (c) {
            case 0:
                // call method #0
                break;
            //...
            case 3:
                // call method #3
                break;
        }
        measures[c] = System.nanoTime() - start;
    }

    System.out.println("Measures: " + Arrays.toString(measures));
}
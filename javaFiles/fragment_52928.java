int[] seq = new int[K];
Arrays.fill(seq, 1);
OUTER: while (true) {
    System.out.println(Arrays.toString(seq));
    for (int i = K - 1; true; i--) {
        int v = seq[i] + 1;
        if (v <= N) {
            seq[i] = v;
            break;
        }
        if (i == 0)
            break OUTER;
        seq[i] = 1;
    }
}
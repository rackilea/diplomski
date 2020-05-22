public static Long[] getNumbers(long N) {
    int porog = 10;
    LinkedList<Long> list = new LinkedList<>();
    // initial powers for the number 0-9
    long[] powers = { 0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l };

    for (long i = 1; i < N; i++) {
        if (i == porog) {
            porog *= 10;
            // calculate i^length
            for (int pi = 1; pi < 10; pi++) {
                powers[pi] *= pi;
            }
        }
        long s = i;
        long k = 0;
        while (s > 0) {
            int r = (int)(s % 10);
            k += powers[r];
            if (k > i)
                break;
            s /= 10;
        }

        if (k == i)
            list.add(i);
    }

    return list.toArray(new Long[]{});
}
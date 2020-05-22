public static void main(String[] args) throws IOException {
    char[] chars = new char[1000000000];
    Random rand = new Random();
    for (int i = 0; i < chars.length; i++)
        chars[i] = (char) (rand.nextInt(26) + 'a');
    String s = new String(chars);

    long start = System.currentTimeMillis();
    int[] freqArr = IntStream.range(0, s.length() - 1).parallel()
            .collect(() -> new int[128 * 128],
                    (arr, i) -> arr[s.charAt(i) * 128 + s.charAt(i + 1)]++,
                    (a, b) -> sum(a, b));
    Map<String, Integer> freq = new TreeMap<>();
    for (int i = 0; i < freqArr.length; i++) {
        int c = freqArr[i];
        if (c == 0) continue;
        String key = "" + (char) (i >> 7) + (char) (i & 0x7f);
        freq.put(key, c);
    }
    long time = System.currentTimeMillis() - start;
    System.out.println("Took " + time + " ms " + freq);
}

static int[] sum(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++)
        a[i] += b[i];
    return a;
}
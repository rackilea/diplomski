public static void main(String[] args) throws IOException {
    char[] chars = new char[1000000000];
    Random rand = new Random();
    for (int i = 0; i < chars.length; i++)
        chars[i] = (char) (rand.nextInt(26) + 'a');
    String s = new String(chars);

    long start = System.currentTimeMillis();
    Map<String, Integer> freq = IntStream.range(0, s.length() - 1).parallel()
            .mapToObj(i -> s.substring(i, i + 2))
            .collect(Collectors.groupingBy(w -> w, Collectors.summingInt(e -> 1)));
    long time = System.currentTimeMillis() - start;
    System.out.println("Took " + time + " ms " + freq);
}
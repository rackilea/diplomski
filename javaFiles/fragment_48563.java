String[] input = {"bat", "bta", "cat", "tca", "vish"}; 
Collection<List<String>> grouped = Stream.of(input)
          .collect(Collectors.groupBy(w -> sortLetters(w))
          .values();

public static String sortLetters(String w) {
    char[] letters = w.toCharArray();
    Arrays.sort(letters);
    return new String(letters);
}
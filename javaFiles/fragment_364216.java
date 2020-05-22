public static void main(String[] args) {
    String string = "This is a long sentence";
    List<String> wordList = Arrays.asList(string.split("\\s+"));

    String shortest = wordList
            .stream()
            .min(Comparator.comparingInt(String::length))
            .orElse(null);
    System.out.println(shortest); //prints "a"

    String longest = wordList
            .stream()
            .max(Comparator.comparingInt(String::length))
            .orElse(null);
    System.out.println(longest); //prints "sentence"
}
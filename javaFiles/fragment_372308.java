public static void main(String... args) {
    IndexedMultiset<String> wordCounts = new IndexedMultiset<>();

    wordCounts.add("foo");
    wordCounts.add("bar");
    wordCounts.add("baz");
    wordCounts.add("baz");

    System.out.println(wordCounts.descendingCounts()); //[baz: 2, bar: 1, foo: 1]


    wordCounts.add("foo");
    wordCounts.add("foo");
    wordCounts.add("foo");

    System.out.println(wordCounts.descendingCounts()); //[foo: 4, baz: 2, bar: 1]
}
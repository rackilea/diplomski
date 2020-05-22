public static void main(String[] args) {
    List<Replacement> replacements = List.of(
            new Replacement(0, "num", "String"), 
            new Replacement(4, "foo", "bar"));

    System.out.println(replaceRanges("num foo", replacements)); // Output: String bar
    System.out.println(replaceRanges("num_fooBar", replacements)); // Output: String_barBar
    System.out.println(replaceRanges("num_f", replacements)); // Output: String_f
    System.out.println(replaceRanges("", replacements)); // Output: 
    System.out.println(replaceRanges("foonum", replacements)); // Output: foonum
}
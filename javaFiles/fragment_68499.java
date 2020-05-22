public static void main(String[] args) {
    System.out.println(commonSuffixWithRecursion("dbc", "abc"));    // bc
    System.out.println(commonSuffixWithRecursion("a", "a"));    // a
    System.out.println(commonSuffixWithRecursion("ab", "b"));   // b
    System.out.println(commonSuffixWithRecursion("a", "b"));    // empty
}
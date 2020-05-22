// The concept of an infinite sequence is that there is always a next.
abstract static class InfiniteIterator<T> implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return true;
    }

}

// The digits of all decimal numbers concatenated.
static class InfiniteDigits extends InfiniteIterator<Character> {

    // The number we are working on.
    int n = 1;
    // The String version of n
    String s = Integer.toString(n);
    // Where we are in the string.
    int i = 0;

    @Override
    public Character next() {
        if (i >= s.length()) {
            s = Integer.toString(++n);
            i = 0;
        }
        return s.charAt(i++);
    }

}

// Finds a String in a stream of characters.
static class StringFinder {

    // The source of the stream.
    final Iterator<Character> source;
    // Track of the past.
    final StringBuilder traversed = new StringBuilder();

    public StringFinder(Iterator<Character> source) {
        this.source = source;
    }

    public int find(final String find) {
        // How far we've matched.
        int matched = 0;
        // How many characters we've passed.
        int passed = 0;
        // Walk the source until we get a match.
        while (matched < find.length()) {
            Character next = source.next();
            traversed.append(next);
            if (next == find.charAt(matched)) {
                // Still matching!
                matched += 1;
            } else {
                // Mismatch.
                passed += matched + 1;
                matched = 0;
            }
        }
        // Want 1-based position.
        return passed + 1;
    }
}

private void test(String string) {
    StringFinder finder = new StringFinder(new InfiniteDigits());
    System.out.println("'" + string + "' found at " + finder.find(string) + " traversed " + finder.traversed);
}

public void test() {
    test("567");
    test("1112");
    test("765");
}
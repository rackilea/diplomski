public static int lengthOfLongestSubstring(String s) {

    Deque<Character> primary = new ArrayDeque<>();
    Deque<Character> secondary = new ArrayDeque<>();
    Deque<Character> longest = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (primary.contains(c)) {
            // Store longest
            if (primary.size() > longest.size()) {
                longest = new ArrayDeque<>(primary);
            }

            while (primary.peek() != c) {
                secondary.offerLast(primary.poll());
            }
            secondary.offerFirst(c);
            primary = secondary;
            secondary = new ArrayDeque<>();  // Altered
        } else {
            primary.offerFirst(c);
        }
    }

    // Also check at end of line.
    if (primary.size() > longest.size()) {
        longest = primary;
    }

    return longest.size();
}
private static int findMatches(List<Character> text, List<Character> pattern) {
    int n = text.size();
    int m = pattern.size();
    int count = 0;  // tracks number of matches found

    for (int i = 0; i <= n - m; i++) { 
        int k = 0;
        while (k < m && text.get(i + k) == pattern.get(k))
        k++;
        if (k == m) { // if we reach the end of the pattern
            k = 0;
            count++;
        }
    }
    return count;
}
static final char[][] pairs = { { '{', '}' }, { '(', ')' }, { '[', ']' } };

public boolean typeMatch(char c1, char c2) {
    for (char[] pair : pairs) {
        if (c1 == pair[0] || c1 == pair[1]) {
            return c2 == pair[0] || c2 == pair[1];
        }
    }
    return false;
}
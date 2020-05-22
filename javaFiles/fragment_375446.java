public static boolean lessThan(char[] s, char[] t, int n) {

    int minLength = Math.min(Math.min(s.length, t.length), n);

    for (int i = 0; i < minLength; i++) {
        if (s[i] < t[i]) {
            return true;
        } else if (s[i] > t[i]) {
            return false;
        }
    }

    return (minLength < n && s.length < t.length) ? true : false;
}
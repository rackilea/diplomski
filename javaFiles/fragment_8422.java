class SplitFixedWidthString {

    // Total length of String.
    final int len;
    // The lengths of the parts to split it into.
    final int[] parts;
    // The current contents of the string.
    final StringBuilder s;
    // The required delimiter.
    final String delimiter;

    public SplitFixedWidthString(String delimiter, char pad, int... parts) {
        this.parts = parts;
        int l = 0;
        for (int i = 0; i < parts.length; i++) {
            l += parts[i];
        }
        this.len = l;
        s = new StringBuilder(len);
        s.setLength(len);
        // Fill it.
        for (int i = 0; i < len; i++) {
            s.setCharAt(i, pad);
        }
        this.delimiter = delimiter;
    }

    public void append(char ch) {
        // Add the character.
        s.append(ch);
        // Remove any spare at the front.
        if (s.length() > len) {
            s.delete(0, s.length() - len);
        }
    }

    public String[] parts() {
        // Roll out into an array of parts.
        String[] p = new String[parts.length];
        int start = 0;
        for (int i = 0; i < parts.length; i++) {
            p[i] = s.substring(start, start + parts[i]);
            start += parts[i];
        }
        return p;
    }

    @Override
    public String toString() {
        // Roll out all parts as a String.
        StringBuilder r = new StringBuilder();
        String[] p = parts();
        boolean first = true;
        for (String s : p) {
            if (!first) {
                r.append(delimiter);
            }
            r.append(s);
            first = false;
        }
        return r.toString();
    }

}

public void test() {
    SplitFixedWidthString s = new SplitFixedWidthString("$", '0', 3, 2);
    char[] test = new char[]{'1', '2', '3', '4', '5'};
    for (char c : test) {
        s.append(c);
        System.out.println(s);
    }
}
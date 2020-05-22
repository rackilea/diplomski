import net.davidashen.text.Hyphenator;

public class WordDistance {

    public static void main(String args[]) throws Exception {
        Hyphenator h = new Hyphenator();
        h.loadTable(WordDistance.class.getResourceAsStream("hyphen.tex"));
        getSyllableLevenshteinDistance(h, args[0], args[1]);
    }

    /**
     * <p>
     * Calculate Syllable Levenshtein distance between two words </p>
     * The Syllable Levenshtein distance is defined as the minimal number of
     * case-insensitive syllables you have to replace, insert or delete to transform word1 into word2.
     * @return int
     * @throws IllegalArgumentException if either str1 or str2 is <b>null</b>
     */
    public static int getSyllableLevenshteinDistance(Hyphenator h, String s, String t) {
        if (s == null || t == null)
            throw new NullPointerException("Strings must not be null");

        final String hyphen = Character.toString((char) 173);
        final String[] ss = h.hyphenate(s).split(hyphen);
        final String[] st = h.hyphenate(t).split(hyphen);

        final int n = ss.length;
        final int m = st.length;

        if (n == 0)
            return m;
        else if (m == 0)
            return n;

        int p[] = new int[n + 1]; // 'previous' cost array, horizontally
        int d[] = new int[n + 1]; // cost array, horizontally

        for (int i = 0; i <= n; i++)
            p[i] = i;

        for (int j = 1; j <= m; j++) {
            d[0] = j;
            for (int i = 1; i <= n; i++) {
                int cost = ss[i - 1].equalsIgnoreCase(st[j - 1]) ? 0 : 1;
                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
            }
            // copy current distance counts to 'previous row' distance counts
            int[] _d = p;
            p = d;
            d = _d;
        }

        // our last action in the above loop was to switch d and p, so p now actually has the most recent cost counts
        return p[n];
    }

}
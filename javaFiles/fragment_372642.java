private void magicSort(List<String> list, String seed) {
    list.sort(new ShuffleComparator(seed));
}

public class ShuffleComparator implements Comparator<String> {
    private static final long MAGIC = 0x5DEECE66DL;
    private final String seed;

    public ShuffleComparator(String seed) {
        this.seed = seed;
    }

    @Override
    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int lim = Math.min(len1, len2);

        int seedLen = seed.length();
        long random = seed.hashCode();

        for (int k = 0; k < lim; k++) {
            random = random * MAGIC + seed.charAt(k % seedLen);
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);
            if (c1 != c2) {
                return ((random % (c1 + 0xFFFF)) & 0xFFFF) -
                    ((random % (c2 + 0xFFFF)) & 0xFFFF) > 0 ? 1 : -1;
            }
        }
        return (random > 0 ? 1 : -1) * (len1 - len2);
    }
}
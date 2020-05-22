import vanilla.java.chronicle.Chronicle;
import vanilla.java.chronicle.Excerpt;
import vanilla.java.chronicle.impl.IndexedChronicle;
import vanilla.java.chronicle.tools.ChronicleTest;

import java.io.IOException;
import java.util.*;

public class Main {
    static final String TMP = System.getProperty("java.io.tmpdir");

    public static void main(String... args) throws IOException {
        String baseName = TMP + "/test";
        String[] keys = generateAndSave(baseName, 100 * 1000 * 1000);

        long start = System.nanoTime();
        SavedSortedMap map = new SavedSortedMap(baseName);
        for (int i = 0; i < keys.length / 100; i++) {
            long l = map.lookup(keys[i]);
//            System.out.println(keys[i] + ": " + l);
        }
        map.close();
        long time = System.nanoTime() - start;

        System.out.printf("Load of %,d records and lookup of %,d keys took %.3f seconds%n",
                keys.length, keys.length / 100, time / 1e9);
    }

    static SortedMap<String, Long> generateMap(int keys) {
        SortedMap<String, Long> ret = new TreeMap<>();
        while (ret.size() < keys) {
            long n = ret.size();
            String key = Long.toString(n);
            while (key.length() < 9)
                key = '0' + key;
            ret.put(key, n);
        }
        return ret;
    }

    static void saveData(SortedMap<String, Long> map, String baseName) throws IOException {
        Chronicle chronicle = new IndexedChronicle(baseName);
        Excerpt excerpt = chronicle.createExcerpt();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            excerpt.startExcerpt(2 + entry.getKey().length() + 8);
            excerpt.writeUTF(entry.getKey());
            excerpt.writeLong(entry.getValue());
            excerpt.finish();
        }
        chronicle.close();
    }

    static class SavedSortedMap {
        final Chronicle chronicle;
        final Excerpt excerpt;
        final String midKey;
        final long size;

        SavedSortedMap(String baseName) throws IOException {
            chronicle = new IndexedChronicle(baseName);
            excerpt = chronicle.createExcerpt();
            size = chronicle.size();
            excerpt.index(size / 2);
            midKey = excerpt.readUTF();
        }

        // find exact match or take the value after.
        public long lookup(CharSequence key) {
            if (compareTo(key, midKey) < 0)
                return lookup0(0, size / 2, key);
            return lookup0(size / 2, size, key);
        }

        private final StringBuilder tmp = new StringBuilder();

        private long lookup0(long from, long to, CharSequence key) {
            long mid = (from + to) >>> 1;
            excerpt.index(mid);
            tmp.setLength(0);
            excerpt.readUTF(tmp);
            if (to - from <= 1)
                return excerpt.readLong();
            int cmp = compareTo(key, tmp);
            if (cmp < 0)
                return lookup0(from, mid, key);
            if (cmp > 0)
                return lookup0(mid, to, key);
            return excerpt.readLong();
        }

        public static int compareTo(CharSequence a, CharSequence b) {
            int lim = Math.min(a.length(), b.length());
            for (int k = 0; k < lim; k++) {
                char c1 = a.charAt(k);
                char c2 = b.charAt(k);
                if (c1 != c2)
                    return c1 - c2;
            }
            return a.length() - b.length();
        }

        public void close() {
            chronicle.close();
        }
    }

    private static String[] generateAndSave(String baseName, int keyCount) throws IOException {
        SortedMap<String, Long> map = generateMap(keyCount);
        saveData(map, baseName);
        ChronicleTest.deleteOnExit(baseName);

        String[] keys = map.keySet().toArray(new String[map.size()]);
        Collections.shuffle(Arrays.asList(keys));
        return keys;
    }
}
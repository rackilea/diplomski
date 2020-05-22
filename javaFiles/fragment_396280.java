package mcve;

import java.util.*;
import java.util.stream.*;

public class OAHashTable {
    private Entry[] table = new Entry[16]; // Must be >= 4. See findSlot.
    private int     size  = 0;

    public int size() {
        return size;
    }

    private int hash(Object key) {
        int hashCode = Objects.hashCode(key)
            & 0x7F_FF_FF_FF; // <- This is like abs, but it works
                             //    for Integer.MIN_VALUE. We do this
                             //    so that hash(key) % table.length
                             //    is never negative.
        return hashCode;
    }

    private int findSlot(Object key) {
        int i = hash(key) % table.length;

        // Search until we either find the key, or find an empty slot.
        //
        // Note: this becomes an infinite loop if the key is not already
        //       in the table AND every element in the array is occupied.
        //       With the resizing logic (below), this will only happen
        //       if the table is smaller than length=4.
        while ((table[i] != null) && !Objects.equals(table[i].key, key)) {
            i = (i + 1) % table.length;
        }

        return i;
    }

    public Object get(Object key) {
        int i = findSlot(key);
        if (table[i] != null) { // Key is in table.
            return table[i].value;
        } else {                // Key is not in table
            return null;
        }
    }

    private boolean tableIsThreeQuartersFull() {
        return ((double) size / (double) table.length) >= 0.75;
    }

    private void resizeTableToTwiceAsLarge() {
        Entry[] old = table;

        table = new Entry[2 * old.length];
        size  = 0;

        for (Entry e : old) {
            if (e != null) {
                put(e.key, e.value);
            }
        }
    }

    public void put(Object key, Object value) {
        int i = findSlot(key);
        if (table[i] != null) { // We found our key.
            table[i].value = value;
            return;
        }
        if (tableIsThreeQuartersFull()) {
            resizeTableToTwiceAsLarge();
            i = findSlot(key);
        }
        table[i] = new Entry(key, value);
        ++size;
    }

    public void remove(Object key) {
        int i = findSlot(key);
        if (table[i] == null) {
            return; // Key is not in the table.
        }

        int j = i;
        table[i] = null;
        --size;

        while (true) {
            j = (j + 1) % table.length;
            if (table[j] == null) {
                break;
            }
            int k = hash(table[j].key) % table.length;
            // Determine if k lies cyclically in (i,j]
            // |    i.k.j |
            // |....j i.k.| or  |.k..j i...|
            if ( (i<=j) ? ((i<k)&&(k<=j)) : ((i<k)||(k<=j)) ) {
                continue;
            }
            table[i] = table[j];
            i = j;
            table[i] = null;
        }
    }

    public Stream<Entry> entries() {
        return Arrays.stream(table).filter(Objects::nonNull);
    }

    @Override
    public String toString() {
        return entries().map(e -> e.key + "=" + e.value)
                        .collect(Collectors.joining(", ", "{", "}"));
    }

    public static class Entry {
        private Object key;
        private Object value;

        private Entry(Object key, Object value) {
            this.key   = key;
            this.value = value;
        }

        public Object getKey()   { return key;   }
        public Object getValue() { return value; }
    }

    public static void main(String[] args) {
        OAHashTable t = new OAHashTable();

        t.put("A", 1);
        t.put("B", 2);
        t.put("C", 3);

        System.out.println("size = " + t.size());
        System.out.println(t);

        t.put("X", 4);
        t.put("Y", 5);
        t.put("Z", 6);
        t.remove("C");
        t.remove("B");
        t.remove("A");

        t.entries().map(e -> e.key)
                   .map(key -> key + ": " + t.get(key))
                   .forEach(System.out::println);
    }
}
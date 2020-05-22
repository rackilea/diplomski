import java.util.*;

public class ListExample {
    public static final void main(String[] args) {
        List<short[]> list;

        // Direct use (no copies)
        list = new LinkedList<short[]>();
        list.add(new short[] { 0, 0, 0 });
        System.out.println("list.size() before direct use: " + list.size());
        System.out.println("list.get(0)[0] before direct use: " + list.get(0)[0]);
        new DirectUser(list).doSomething();
        System.out.println("list.size() after direct use: " + list.size());
        System.out.println("list.get(0)[0] after direct use: " + list.get(0)[0]);
        // Output, note how both the list and its contents have been changed:
        // list.size() before direct use: 1
        // list.get(0)[0] before direct use: 0
        // list.size() after direct use: 2
        // list.get(0)[0] after direct use: 1

        // Copying the list, but note that the entries are shared by both lists:
        list = new LinkedList<short[]>();
        list.add(new short[] { 0, 0, 0 });
        System.out.println("list.size() before copy-list use: " + list.size());
        System.out.println("list.get(0)[0] before copy-list use: " + list.get(0)[0]);
        new CopyListUser(list).doSomething();
        System.out.println("list.size() after copy-list use: " + list.size());
        System.out.println("list.get(0)[0] after copy-list use: " + list.get(0)[0]);
        // Output, note how our list didn't change (it doesn't have a new entry), but
        // the entry at index 0 *was* changed:
        // list.size() before copy-list use: 1
        // list.get(0)[0] before copy-list use: 0
        // list.size() after copy-list use: 1
        // list.get(0)[0] after copy-list use: 1

        // "Deep" copying, both the list and its entries:
        list = new LinkedList<short[]>();
        list.add(new short[] { 0, 0, 0 });
        System.out.println("list.size() before deep-copy use: " + list.size());
        System.out.println("list.get(0)[0] before deep-copy use: " + list.get(0)[0]);
        new DeepCopyUser(list).doSomething();
        System.out.println("list.size() after deep-copy use: " + list.size());
        System.out.println("list.get(0)[0] after deep-copy use: " + list.get(0)[0]);
        // Output, note that neither the list nor its entries was affected by the call:
        // list.size() before deep-copy use: 1
        // list.get(0)[0] before deep-copy use: 0
        // list.size() after deep-copy use: 1
        // list.get(0)[0] after deep-copy use: 0


        System.exit(0);
    }

    static class DirectUser {
        List<short[]> items;

        DirectUser(List<short[]> items) {
            // DirectUser doesn't copy the list
            this.items = items;
        }

        void doSomething() {
            this.items.get(0)[0] = 1;
            this.items.add(new short[] { 2, 2, 2 });
        }
    }

    static class CopyListUser {
        List<short[]> items;

        CopyListUser(List<short[]> items) {
            // CopyListUser copies the list, but both lists still share items
            this.items = new LinkedList<short[]>(items);
        }

        void doSomething() {
            this.items.get(0)[0] = 1;
            this.items.add(new short[] { 2, 2, 2 });
        }
    }

    static class DeepCopyUser {
        List<short[]> items;

        DeepCopyUser(List<short[]> items) {
            // DeepCopyUser copies the list AND each entry
            this.items = new LinkedList<short[]>();
            for (short[] entry : items) {
                this.items.add(Arrays.copyOf(entry, entry.length));
            }
        }

        void doSomething() {
            this.items.get(0)[0] = 1;
            this.items.add(new short[] { 2, 2, 2 });
        }
    }
}
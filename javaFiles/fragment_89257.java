public class ArrayDirectory implements Directory {
    Entry[] entries = new Entry[1];

    public void addEntry(Entry newEntry) {
        Entry[] temp = new Entry[entries.length + 1];
        for (int i = 0; i < entries.length; i++) {
            temp[i] = entries[i];
        }
        newEntry = new Entry("isajas","ssds", "sasdas");
        temp[temp.length - 1] = newEntry;
        entries = temp;
      }
}
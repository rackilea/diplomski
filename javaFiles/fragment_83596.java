class SubHashMap<K, V> extends HashMap<K, V> {

    public void dumpBuckets() throws Exception {

        Field f = HashMap.class.getDeclaredField("table");
        f.setAccessible(true);

        Map.Entry<K, V>[] table = (Map.Entry<K, V>[]) f.get(this);

        Class<?> hashMapEntryClass = null;
        for (Class<?> c : HashMap.class.getDeclaredClasses())
            if ("java.util.HashMap.Entry".equals(c.getCanonicalName()))
                hashMapEntryClass = c;

        Field nextField = hashMapEntryClass.getDeclaredField("next");
        nextField.setAccessible(true);

        for (int i = 0; i < table.length; i++) {

            System.out.print("Bucket " + i + ": ");
            Map.Entry<K, V> entry = table[i];

            while (entry != null) {
                System.out.print(entry.getKey() + " ");
                entry = (Map.Entry<K, V>) nextField.get(entry);
            }

            System.out.println();
        }
    }
}
private void buckets(HashMap<String, String> m) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    // Pull out the table.
    Field f = m.getClass().getDeclaredField("table");
    f.setAccessible(true);
    Object[] table = (Object[]) f.get(m);
    int bucket = 0;
    // Walk it.
    for (Object o : table) {
        if (o != null) {
            // At least one in this bucket.
            int count = 1;
            // What's in the `next` field?
            Field nf = o.getClass().getDeclaredField("next");
            nf.setAccessible(true);
            Object n = nf.get(o);
            if (n != null) {
                do {
                    // Count them.
                    count += 1;
                } while ((n = nf.get(n)) != null);
            }
            System.out.println("Bucket " + bucket + " contains " + count + " entries");
        }
        bucket += 1;
    }
}

public void test() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    HashMap<String, String> m = new HashMap<>();
    String[] data = {"One", "Two", "Three", "Four", "five"};
    for (String s : data) {
        m.put(s, s);
    }
    buckets(m);
}
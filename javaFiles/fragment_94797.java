public static void main(String[] args) {

    TreeMap<String, Object> map = new TreeMap<String, Object>();

    int count = 1000000;
    ArrayList<String> uuids;

    {
        System.out.print("generating ... ");
        long start = System.currentTimeMillis();
        uuids = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    {
        System.out.print("inserting .... ");
        long start = System.currentTimeMillis();

        Object o = new Object();
        for (int i = 0; i < count; i++) {
            map.put(uuids.get(i), o);
        }

        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    {
        System.out.print("querying ..... ");

        String from = "be400000-0000-0000-0000-000000000000";
        String to =   "be4fffff-ffff-ffff-ffff-ffffffffffff";

        long start = System.currentTimeMillis();

        long matches = 0;

        for (int i = 0; i < count; i++) {
            Map<String, Object> result = map.subMap(from, to);
            matches += result.size();
        }

        System.out.println((System.currentTimeMillis() - start) + "ms (" + matches/count
                + " matches)");

    }
}
{
        long start = System.currentTimeMillis();
        rt.storeRecords(Integer.parseInt(args[1]));
        long end = System.currentTimeMillis();
        System.out.println("store duration: " + (end - start));
    }

    {
        long start = System.currentTimeMillis();
        rt.fetchRecords(Integer.parseInt(args[1]));
        long end = System.currentTimeMillis();
        System.out.println("fetch duration: " + (end - start));
    }
}

private Database db;
private Index ix;
private Random random = new Random();
private List<String> keys = new ArrayList<String>();
private int seed = 113;

public boolean dbOpen(String home) throws Exception {
    DatabaseConfig config = new DatabaseConfig();
    config.baseFile(new File(home));
    config.durabilityMode(DurabilityMode.NO_FLUSH);
    config.minCacheSize(500000000);
    db = Database.open(config);
    ix = db.openIndex("moe");
    return true;
}

public int storeRecords(int i) throws Exception {
    int j;
    long size = 0;

    random.setSeed(seed);

    for (j = 0; j < i; j++) {
        String k = Long.toString(random.nextLong());
        byte[] data = new byte[5000 + random.nextInt(10000)];
        keys.add(k);

        size += data.length;

        random.nextBytes(data);
        ix.store(null, k.getBytes(), data);
    }

    System.out.println("GENERATED SIZE: " + size);

    db.checkpoint();
    return j;
}

public int fetchRecords(int i) throws Exception {
    int j, res;

    random.setSeed(seed);
    res = 0;

    for (j = 0; j < i; j++) {
        String k = Long.toString(random.nextLong());
        byte[] data = new byte[5000 + random.nextInt(10000)];
        random.nextBytes(data);
        byte[] val = ix.load(null, k.getBytes());
        if (Arrays.equals(data, val)) {
            res++;
        } else {
            System.err.println("FETCH differs: " + j);
            System.err.println(data.length + " " + val.length);
        }
    }

    return res;
}

public int fetchRandom(int i) throws Exception {
    for (int j = 0; j < i; j++) {
        String k = keys.get(random.nextInt(keys.size()));
        ix.load(null, k.getBytes());
    }

    return i;
}
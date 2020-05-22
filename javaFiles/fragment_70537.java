public static Map<String, Set<Long>> read(String filename) throws IOException {
    Map<String, Set<Long>> ret = new LinkedHashMap<>();
    try (DataInputStream dis = new DataInputStream(new BufferedInputStream(
            new InflaterInputStream(new FileInputStream(filename))))) {
        for (int i = 0, size = dis.readInt(); i < size; i++) {
            String key = dis.readUTF();
            Set<Long> values = new LinkedHashSet<>();
            ret.put(key, values);
            for (int j = 0, size2 = dis.readInt(); j < size2; j++)
                values.add(dis.readLong());
        }
    }
    return ret;
}

public static void main(String... ignored) throws IOException {
    Map<String, Set<Long>> map = new LinkedHashMap<>();
    for (int i = 0; i < 20000; i++) {
        Set<Long> set = new LinkedHashSet<>();
        set.add(System.currentTimeMillis());
        map.put("key-" + i, set);
    }
    for (int i = 0; i < 5; i++) {
        long start = System.nanoTime();
        File file = File.createTempFile("delete", "me");
        write(file.getAbsolutePath(), map);
        Map<String, Set<Long>> map2 = read(file.getAbsolutePath());
        if (!map2.equals(map)) {
            throw new AssertionError();
        }
        long time = System.nanoTime() - start;
        System.out.printf("With %,d  keys, the file used %.1f KB, took %.1f to write/read ms%n", map.size(), file.length() / 1024.0, time / 1e6);
        file.delete();
    }
}
System.out.printf("The average memory used by simple entry is %.1f bytes%n", new SizeofUtil() {
    @Override
    protected int create() {
        Map.Entry<String, String> e = new AbstractMap.SimpleEntry<String, String>(null, null);
        return 1;
    }
}.averageBytes());
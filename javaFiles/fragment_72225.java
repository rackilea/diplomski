class KeyWordedMap<T> extends HashMap<Integer, T> {
    private final String keyword;

    public KeyWordedMap(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends T> m) {
        for (Map.Entry<? extends Integer, ? extends T> entry : m.entrySet()) {
            int i = entry.getKey();
            while (this.containsKey(i)) {
                i++;
            }
            this.put(i, entry.getValue());
        }
    }
}
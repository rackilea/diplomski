class HashMapChecker implements Checker {
    private final Map<String, Object> map = new HashMap<>(1000);
    {
        for (String s : VALUES)
            map.put(s, s);
    }
    @Override
    public boolean contains(String s) {
        return map.containsKey(s);
    }
}
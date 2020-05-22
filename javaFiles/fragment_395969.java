class A {
    static Map<String, Integer> romans = initRomans();

    private static Map<String, Integer> initRomans() {
        Map<String, Integer> r = new HashMap<>();
        r.put("I", 1);
        r.put("V", 5);
        r.put("X", 10);
        return r;
    }
}
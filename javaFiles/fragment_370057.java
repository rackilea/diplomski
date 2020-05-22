public static void main(String[] args) throws java.lang.Exception {
    Field f = HashMap.class.getDeclaredField("threshold");
    f.setAccessible(true);

    long mem = Runtime.getRuntime().freeMemory();
    Map<String, String> map = new HashMap<>(2 << 12, 1); // 8,192
    System.out.println("threshold of empty map = " + f.get(map));
    System.out.println("size of empty map = " + (mem - Runtime.getRuntime().freeMemory()));

    mem = Runtime.getRuntime().freeMemory();
    for (int i = 0; i < 8192; i++) {
        map.put(String.valueOf(i), String.valueOf(i));
    }
    System.out.println("threshold of filled map = " + f.get(map));
    System.out.println("size of filled map = " + (mem - Runtime.getRuntime().freeMemory()));

    mem = Runtime.getRuntime().freeMemory();
    map.put("a", "a");
    System.out.println("threshold with one more entry = " + f.get(map));
    System.out.println("size with one more entry = " + (mem - Runtime.getRuntime().freeMemory()));
}
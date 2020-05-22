public static void main(String[] args) {
    Map<String, String> map1 = new HashMap<>();
    map1.put("k1", "v1");
    map1.put("k2", "v2");
    map1.put("k3", "v3");

    Map<String, String> map2 = new HashMap<>();
    map2.put("v1", "val1");
    map2.put("v2", "val2");
    map2.put("v3", "val3");

    map1.replaceAll((k, v) -> map2.get(v));

    System.out.println(map1); // prints "{k1=val1, k2=val2, k3=val3}"
}
public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "A");
    map.put("2", "B");
    map.put("3", "C");
    map.put("4", "B");
    map.put("5", "B");
    map.put("6", "C");

    System.out.println(count("B", map)); // output is 3
}

static int count(String id, Map<String, String> map) {
    int i = 0;
    for (String val : map.values()) {
        if (id.equals(val))
            i++;
    }
    return i;
}
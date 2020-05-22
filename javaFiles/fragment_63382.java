public static String[] sort(String test) {
    String[] strings = test.split(" ");
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    for (String s : strings) {
        Integer i = map.get(s);
        if (i != null) {
            map.put(s, i+1);
        } else {
            map.put(s, 1);
        }
    }

    TreeMap<Integer,String> sort = new TreeMap<Integer,String>(Collections.reverseOrder());
    for (Entry<String,Integer> e : map.entrySet()) {
        sort.put(e.getValue(), e.getKey());
    }

    return sort.values().toArray(new String[0]);
}
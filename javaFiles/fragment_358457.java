String[] input = {"9-11", "9-01", "10-02", "10-01", "2-09", "3-88", "9-03"};
    Map<Integer, String> map = new TreeMap<Integer, String>();
    for (String s : input) {
        map.put(Integer.valueOf(s.replace("-", "")), s);
    }
    TreeSet<Integer> set = new TreeSet<Integer>(map.keySet());
    String[] output = new String[input.length];
    int i = 0;
    for (Integer key : set) {
        output[i++] = map.get(key);
    }
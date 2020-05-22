public void start() {
    List<Integer> list = getList(1, 1, 5, 3, 7, 3, 11, 2, 3, 1);

    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    for (Integer i : list) {
        Integer retrievedValue = map.get(i);
        if (null == retrievedValue) {
            map.put(i, 1);
        }
        else {
            map.put(i, retrievedValue + 1);
        }
    }

    System.out.println("list: " + list);
    printCount(map);
}
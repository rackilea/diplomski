HashMap<String, Integer> hMap = new HashMap<String, Integer>();
    hMap.put("one", 500);
    hMap.put("two", 600);
    hMap.put("three", 700);

    Collection c = hMap.values();
    Iterator itr = c.iterator();
    while (itr.hasNext()) {
        System.out.println(itr.next());
    }
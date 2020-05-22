Map<String, Integer> ohm = new HashMap<String, Integer>();
    List<HashMap<String,Integer>> test = new ArrayList<HashMap<String, Integer>>();

    ohm.put("one", 1);
    ohm.put("two", 2);

    test.add((HashMap)ohm);

    int number = test.get(0).get("two");
    System.out.println(number);
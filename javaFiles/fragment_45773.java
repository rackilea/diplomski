Map<String, Object> ohm = new HashMap<String, Object>();
    List<HashMap<String,Object>> test = new ArrayList<HashMap<String, Object>>();

    ohm.put("one", 1);
    ohm.put("two", 2);

    test.add((HashMap)ohm);

    int number = (Integer)test.get(0).get("one");
    System.out.println(number);
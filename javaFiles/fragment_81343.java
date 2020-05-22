Map<String, String> map = new HashMap<String, String>();
    map.put("John", "Red");
    map.put("Pepe", "Blue");
    map.put("Myself", "Red");

    Map<String, Set<String>> out = reverseMap(map);
    System.out.println(out);
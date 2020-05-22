HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("s", 1);
        myMap.put("r", 1);
        myMap.put("m", 1);
        System.out.println(myMap); // This prints {r=1, s=1, m=1}

HashMap<String, Integer> myMap1 = new HashMap<>();
    myMap1.put("s", 1);
    myMap1.put("s", 2);
    myMap1.put("s", 3);
    System.out.println(myMap1); // This prints {s=3}
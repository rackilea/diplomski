ArrayList<Integer> listA = new ArrayList<Integer>();
    listA.add(2);
    listA.add(3);
    listA.add(4);
    listA.add(4);

ArrayList<Integer> listB = new ArrayList<String>();
    listB.add(6);
    listB.add(7);
    listB.add(9);

ArrayList<Integer> listC = new ArrayList<Integer>();
    listC.add(10);
    listC.add(11);
    listC.add(12);
    listC.add(13);

ArrayList<Integer> listD = new ArrayList<Integer>();
    listD.add(1);
    listD.add(18);

    Map<String,List<Integer>> theMap;
    theMap = new HashMap<String,List<Integer>>();
    theMap.put("A",listA);
    theMap.put("B",listB);
    theMap.put("C",listC);
    theMap.put("D",listD);

    /* Access Values */
    int two = theMap.get("A").get(0);
String cold[] = new String[]{"actions","cold","enabled"};
    String warm[] = new String[]{"actions","warm","enabled"};

    List<String> lCold = new ArrayList<String>(Arrays.asList(cold));
    List<String> lWarm = new ArrayList<String>(Arrays.asList(warm));

    List<ArrayList> listOfLists = new ArrayList<ArrayList>();//Create a list of lists
    listOfLists.add((ArrayList<String>) lCold);
    listOfLists.add((ArrayList<String>) lWarm);

    Iterator<ArrayList> firstIterator = listOfLists.iterator();
    while(firstIterator.hasNext()){//Iterate list of lists
        ArrayList<String> list = firstIterator.next();
        list.add("String");
    }       

    for(String s: lCold){
        System.out.println(s);
    }

    for(String s: lWarm){
        System.out.println(s);
    }
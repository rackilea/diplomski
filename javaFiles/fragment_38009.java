ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
    list.add(13);
    list.add(42);
    listOfList.add(list);
    System.out.println("list = " + list);
    System.out.println("listOfList = " + listOfList);

    list1.add(46);
    System.out.println("list = " + list);
    System.out.println("listOfList = " + listOfList);
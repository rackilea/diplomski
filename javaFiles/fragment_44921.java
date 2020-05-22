List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(4);
    list1.add(15);
    list1.add(16);
    list1.add(3);
    list1.add(3);
    list1.add(8);

    System.out.println(list1); // [1, 4, 15, 16, 3, 3, 8]
    Collections.sort(list1);
    System.out.println(list1); // [1, 3, 3, 4, 8, 15, 16]

    //For equals or larger than 3
    int index = list1.indexOf(3);
    List<Integer> list2 = index > -1 ? list1.subList(index, list1.size()) : new ArrayList<>();
    System.out.println(list2); // [3, 3, 4, 8, 15, 16]

    //For equals or smaller than 3
    index = list1.lastIndexOf(3);
    List<Integer> list3 = index > -1 ? list1.subList(0, index + 1) : new ArrayList<>();
    System.out.println(list3); // [1, 3, 3]
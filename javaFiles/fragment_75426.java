ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(new Integer(12));
    list1.add(new Integer(24));
    list1.add(new Integer(36));
    list1.add(new Integer(48));

    ArrayList<Integer> list3 = new ArrayList<>();
    for (Integer integer : list1) {
        list3.add(new Integer(integer.intValue()));
    }
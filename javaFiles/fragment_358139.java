List list = new ArrayList();
    list.add(Arrays.asList("element1", "element2", "element3",
            Arrays.asList("element4.1", "element4.2")));
    list.add(Arrays.asList("element5", "element6", "element7",
            Arrays.asList("element8.1", "element8.2", "element8.3")));

    // print values
    System.out.println(list.get(0));
    System.out.println(list.get(1));
List<String> al = new ArrayList<>();
    al.add("a");
    al.add("b");
    al.add("c");
    al.add("d");

    List<String> sublist = al.subList(0, 3);  //inclusive index 0, exclusive index 3

    for(String s : sublist)
        System.out.println(s);
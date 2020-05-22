List<String> list = new ArrayList<>();
    list.add("pops");
    list.add("chops");
    list.add("zebra");
    list.add("xam");

    for (String str : Ordering.<String>natural().sortedCopy(list)) {
        System.out.println(str);
    }
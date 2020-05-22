List<String> list = new ArrayList<String>();
    list.add("item1");
    list.add("item2");
    list.add("item3");
    list.add("item4");
    System.out.println(list.toString().replace("[", "('").replace("]", "')").replace(", ", "', '"));
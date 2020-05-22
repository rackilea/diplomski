ArrayList<Object> list = new ArrayList<Object>();
    list.add(1);
    list.add("Java");
    list.add(3.14);

    List<String> strings = new ArrayList<String>();
    for (Object object : list) {
        strings.add(object != null ? object.toString() : null);
    }
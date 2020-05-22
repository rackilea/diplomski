List<Object> list = new ArrayList<>();
    list.add("a");
    list.add(2);

    List<String> strList = new ArrayList<>();
    List<Integer> intList = new ArrayList<>();

    for (Object o : list) {
        if (o instanceof String) {
            System.out.println("String is: " + o);
            strList.add((String) o);
        }
        if (o instanceof Integer) {
            System.out.println("Integer is: " + o);
            intList.add((Integer) o);
        }
    }
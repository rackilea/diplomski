List<String> list1 = Arrays.asList("That", "Is");
    List<String> list2 = Arrays.asList("That2", "Is2", "all2");
    List<List<String>> param = new ArrayList<List<String>>();
    param.add(list1);
    param.add(list2);
    param = getAllCombinations(param);
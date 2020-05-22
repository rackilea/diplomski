List<Map<String, Object>> list = new ArrayList<>();
    Map<String,Object> map1 = new HashMap<>();
    map1.put("code", "last_name");
    Map<String,Object> map2 = new HashMap<>();
    map2.put("code", "last_date");
    map2.put("code","last_name");//adding a duplicate on purpose
    Map<String,Object> map3 = new HashMap<>();
    map3.put("code", "task_id");
    list.add(map1);
    list.add(map2);
    list.add(map3);
    List<Object> allCodeKeeper = list.stream().map(o -> o.get("code"))
            .distinct().collect(Collectors.toList());
    System.out.println(allCodeKeeper);
Map<String, List<String>> map = new MultivaluedHashMap<>();
    map.put("b", new ArrayList<>());
    map.put("a", new ArrayList<>());

    List<String> keylist = new ArrayList<>(map.keySet());
    Collections.sort(keylist);
    for(String key : keylist) {
        System.out.println(key +  " : " + map.get(key));
    }
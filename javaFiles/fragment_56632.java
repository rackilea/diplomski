Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
    String first = "FIRST";
    if (map.get(first) == null){
        map.put(first, new ArrayList<Object>());
    }

    map.get(first).add(new Object());
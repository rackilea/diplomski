void populateMap(HashMap<String, List<String>> map, String value, String key) {
        List<String> myList;
        if(!map.containsKey(key)) {
            myList = new ArrayList<String>();
            myList.add(value);
            map.put(key, myList);
        } else {
            myList = map.get(key);
            myList.add(value);
        }
    }
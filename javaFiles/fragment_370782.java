public void loadMap(ResultSet inputResultSet,
        MbGlobalMap inputTranslationObjMap) throws Exception {
    // String key = "";
    List<dept> list = null;
    while (inputResultSet.next()) {
        String name = inputResultSet.getString(1);
        String key = inputResultSet.getString(2);
        // first check if the map has a list already.
        if (inputTranslationObjMap.containsKey(key)) {
            list = inputTranslationObjMap.get(key);
        } else {
            // No... add a new list to the map.
            list = new ArrayList<dept>();
            inputTranslationObjMap.put(key, list);
        }
        dept d1 = new dept(name, key);
        list.add(d1);
    }
}
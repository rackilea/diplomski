for (HashMap<String, String> map : formList)
    for (Entry<String, String> mapEntry : map.entrySet())
        {
        String key = mapEntry.getKey();
        String value = mapEntry.getValue();
        //if you need only keys to display in the listview
        list.add(key);
        }
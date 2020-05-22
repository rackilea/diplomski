HashMap<String, List<String>> map = new HashMap<String, List<String>>();

// ...

List<String> list;
if (map.containsKey(refId))
    list = map.get(refId);
else
    map.put(refid, list = new ArrayList<String>());

// work with list here
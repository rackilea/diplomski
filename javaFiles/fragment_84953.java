List<Map<String,String>> listOfMaps = new ArrayList<Map<String,String>>();

// initialize map1, map2, map3 same as above

listOfMaps.add(map1);
listOfMaps.add(map2);

for (Iterator<Map<String, String>> iterator =
                        listOfMaps.iterator(); iterator.hasNext();) {
    map3.putAll(iterator.next());
}

for (Map.Entry<String, String> mapping : map3.entrySet()) {
    System.out.println(mapping.getKey() + " = " + mapping.getValue());
}
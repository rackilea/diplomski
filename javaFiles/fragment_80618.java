while(...) {
    String keyword = ...;
    String alternate = ...;
    // check whether the list for keyword is present
    List<String> alternateList = alternateMap.get(keyword);
    if(alternateList == null) {
        alternateList = new ArrayList<>();
        alternateMap.put(keyword, alternateList);
    }
    alternateList.add(alternate);
}

// printing the result
for(Map.Entry<String, List<String>> alternateEntry : alternateMap.entrySet()) {
    System.out.println(alternateEntry.getKey() + ": " + 
           alternateEntry.getValue().toString());
}
Map<String, List<Object>> map = new HashMap<String, List<Object>>();
map.add("X", new ArrayList<Object>());
map.add("Y", new ArrayList<Object>());
for (Object obj : list) {
    if (matchesCriteriaX(obj)) {
         List<Object> list = map.get("X");
         list.add(obj);
    else if (matchesCriteriaY(obj)) {
         List<Object> list = map.get("Y");
         list.add(obj);
    }
}
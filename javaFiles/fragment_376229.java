private static Map<String, Object> sortInnerMap(Map<String, Object> unsortedMap) {

    List<Entry<String, Object>> list = new LinkedList<Entry<String, Object>>(unsortedMap.entrySet());

    Collections.sort(list, new Comparator<Entry<String, Object>>() {
        public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
            return ((Comparable) ((ProductType) o1.getValue()).getDispSeq())
                                   .compareTo(((ProductType) o2.getValue()).getDispSeq());
        }
    });

    Map<String, Object> sortedMap = new LinkedHashMap<String, Object>();
    for(Entry<String, Object> item : list){
        sortedMap.put(item.getKey(), item.getValue());
    }
    return sortedMap;
}

private static Map<String, Map<String, Object>> sortOuterMap(
        Map<String, Map<String, Object>> unsortedMap) {

    List<Entry<String, Map<String, Object>>> list = new LinkedList<Entry<String, Map<String, Object>>>(
            unsortedMap.entrySet());

    Collections.sort(list,
            new Comparator<Entry<String, Map<String, Object>>>() {
                public int compare(Entry<String, Map<String, Object>> o1,
                        Entry<String, Map<String, Object>> o2) {
                    return ((Comparable) ((ProductType) o1.getValue()
                            .entrySet().iterator().next().getValue())
                            .getDispSeq()).compareTo(((ProductType) o2.getValue()
                            .entrySet().iterator().next().getValue())
                            .getDispSeq());
                }
            });

    Map<String, Map<String, Object>> sortedMap = new LinkedHashMap<String, Map<String, Object>>();
    for(Entry<String, Map<String, Object>> item : list){
        sortedMap.put(item.getKey(), item.getValue());
    }
    return sortedMap;
}
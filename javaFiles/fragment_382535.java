List<Map.Entry<Integer, Integer>> sortMapValues2(Map<Integer, Integer> map){
    //Sort Map.Entry by value
    List<Map.Entry<Integer, Integer>> result = new ArrayList(map.entrySet());
    Collections.sort(result, new Comparator<Map.Entry<Integer, Integer>>(){
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
    }});

    return result;  
}
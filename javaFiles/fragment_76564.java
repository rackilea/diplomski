LinkedHashMap<Integer,LinkedList<Integer>> myMap = new LinkedHashMap<>();
for(Map.Entry<Integer,LinkedList<Integer>> entry : myMap.entrySet()) {            
    for(Integer temp : entry.getValue()) {
        arr[i] = temp;
        i++;
    }
}
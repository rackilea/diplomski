Map<String, List<String>> map = new HashMap<>(); 
for(Bill b : billings) {
    List<String> list = map.get(b.getId()); //try to get the list with the specified id
    if(list == null) { //if the list is null, it means that there is no mapping yet in the map, so create one
        list = new ArrayList<>();
        map.put(b.getId(), list);
     }
     list.add(b.getEmail()); //add the corresponding email to the list
}
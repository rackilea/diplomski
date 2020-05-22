List<Bar> valuesList = map.get(key);
if(valuesList == null){
    valuesList = new ArrayList<Bar>();
     map.put(key,valuesList);
}
valuesList.add(Item);
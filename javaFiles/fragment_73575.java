ArrayList<Item> original = items.populateTable(roomId);
HashMap<Integer, Integer> refined = new HashMap<>();
for(int i = 0; i < original.size(); i++){
    int key = original.get(i).getStockId();
    int count = refined.containsKey(key) ? refined.get(key) : 0;
    refined.put(key, count + 1);
}
Iterator it1 = refined.entrySet().iterator();
while(it1.hasNext()){
    Map.Entry pair1 = (Map.Entry)it1.next();
    System.out.println(pair1.getKey() + " = " + pair1.getValue());
}
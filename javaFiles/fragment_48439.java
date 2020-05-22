@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    Integer currentCount = 0;
    for (DataSnapshot ds: dataSnapshot.getChildren()){
        String getName = ds.child("name").getValue(String.class);
        currentCount = map.get(getName);
        map.put(getName, currentCount+1);
    }
    //You can print your values using this
    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
    entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    for (Map.Entry<String, Integer> entry : entryList) {
        System.out.printf("%s = %s; \n", entry.getKey(), entry.getValue());
    }
}
List<List<Float[]>> outterList;
Set<Float[]> mySet = new HashSet<Float[]>();
for (List<Float[]> innerList : outterList){
    Iterator<Float[]> iterator = innerList.iterator();
    while(iterator.hasNext()){
        Float[] array = iterator.next();
        boolean added = mySet.add(array);
        if (!added)
           iterator.remove();
    }
}
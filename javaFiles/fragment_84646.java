//NOTE:  this assumes that 'MyObject' has an equals() implementation 
//       that ignores the 'description' field 
List<MyObject> newUpdate = new ArrayList<MyObject>();
List<MyObject> oldUpdate = new ArrayList<MyObject>();
for (MyObject obj : newList) {
    if (oldList.contains(obj)) {
        MyObject oldObj = oldList.get(oldList.indexOf(obj));
        if (! oldObj.getDescription().equals(obj.getDescription())) {
            newUpdate.add(obj);
            oldUpdate.add(oldObj);
        }
    }
}
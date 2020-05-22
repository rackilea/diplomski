//assuming that the array you are filtering is called 'myArray'
List<Object> seenObjects = new ArrayList<Object>();
for (Object obj : myArray) {
    if (! seenObjects.contains(obj)) {
        seenObjects.add(obj);
    }
    else {
        //merge the 'desc' field in 'obj' with the 'desc' field in
        //'seenObjects.get(seenObjects.indexOf(obj))'
    }
}
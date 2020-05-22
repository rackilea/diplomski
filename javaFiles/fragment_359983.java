Object[] arrayOfObjects = new Object[size];
Collection<Object> myNewCollection = new ArrayList<Object>();
// use the addAll
myNewCollection.addAll(arrayOfObjects);

// use an iterator
Iterator<Object> iter = myNewCollection.iterator();
while(iter.hasNext()){
    Object object = iter.next();
    // do something with the object
}
ArrayList<Object> arrayList = new ArrayList<Object>();
    arrayList.add(new Object());
    arrayList.add(new Object());
    arrayList.add(new Object());
    //...
    for (Object o : arrayList) { //iterating with iterator
        arrayList.remove(0); // perform some modification while 
                             //iterating over the structure

    }
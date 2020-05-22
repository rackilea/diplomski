int i = 0;
for (myObj o1 : myObjList) {
    for (myObj o2 : myObjList.subList(i, myObjList.size())) {
        // do something
    }
    i++;
}
boolean add = true;
for (Double doubleNum : myList) {
    if (add) {   
        tempNo = myStringWayToAdd(tempNo , doubleNum+"");
    }
   add = !add;
}
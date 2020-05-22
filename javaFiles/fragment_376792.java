for (int i=0; i<listSize; i++) {

    for (int j=i; j<listSize; j++) {

        tempNum = list.get(i) + list.get(j);
        if (tempNum < limit) {
            sumList.add(tempNum);
        }
    }
}
for (int i = 0; i < listSize; i++){
    for (int j = 0; j < listSize; j++){
        myList[i][j].add(rand.nextInt(100));
        myList[i][j].add(rand.nextInt(100));
        myList[i][j].add(rand.nextInt(100));
    }
}
// In each box you'll have a List, containing 3 values
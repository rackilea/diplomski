//assume number of outside lists are equal to number of map elements
    String[] keysArr = {"stringA", "stringB", "stringC"};
    ArrayList[] outLists = {outListOne, outListTwo, outListThree};

    // adds outside lists to corresponding map ArrayList lists
    for(int i = 0; i < keysArr.length; i++){
        list = map.get(keysArr[i]);  // you ArrayList in a map, get it by key name
        list.addAll(outLists[i]);  // append elements from out list to corresponding list
    }
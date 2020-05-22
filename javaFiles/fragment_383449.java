int size = treeMap.size();
    String [][] ans = new String[size][]; //initialize the known dimension only
    int arrayRow = 0;
    for (Map.Entry<String,List<String>> entry: treeMap.entrySet()){

        int rowSize = entry.getValue().size() + 1;
        String[] tempArray = new String[rowSize]; //an temp array to hold key + vlaues
        tempArray[0] = entry.getKey();            //add key to temp array

        int mn = 1;
        for (String s : entry.getValue()) { tempArray[mn++] = s; } //add values to temp array
        ans[arrayRow++] = tempArray; //add temp array to output array
    }

    return ans;
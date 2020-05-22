String [][]array2D = {{"A", "B"}, {"C", "D"}, {"E", "F"}};
    List<List<String>> arrayList2D = new ArrayList<List<String>>();
    for (int i = 0; i < array2D.length; i++) {
        List<String> eachRecord = new ArrayList<String>();
        for (int j = 0; j < array2D[i].length; j++) {
            eachRecord.add(String.valueOf(array2D[i][j]));
        }
        arrayList2D.add(eachRecord);
    }
    System.out.println(arrayList2D);//[[A, B], [C, D], [E, F]]
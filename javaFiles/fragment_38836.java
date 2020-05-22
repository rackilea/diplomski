String[][] array2D = { { "A", "B" }, { "C", "D" }, { "E", "F" } };
    List<List<String>> arrayList2D = new ArrayList<List<String>>();
    for (int i = 0; i < array2D.length; i++) {
        List<String> eachRecord = Arrays.asList(array2D[i]);
        arrayList2D.add(eachRecord);
    }
    System.out.println(arrayList2D);
String[][] my2Darr = {{5, 2, 3, 1},
                      {4, 2, 6, 9},
                      {8, 9, 1, 8}};
    List<String> list = new ArrayList<>();
    for(int i = 0; i < my2Darr.length; i++) {
        list.addAll(Arrays.asList(my2Darr[i])); // java.util.Arrays
    }
    String[] my1Darr = new String[list.size()];
    my1Darr = list.toArray(my1Darr);
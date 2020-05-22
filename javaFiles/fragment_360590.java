List<List<String>> resultList = new ArrayList<List<String>>();
for (int i = 1; i <= 9; i++) {

    List<String> innerList = new ArrayList<String>();
    resultList.add(innerList);
    for (int j = 1; j <= 9; j++) {
        innerList.add(j + "");
    }
}

List<String[]> data = new ArrayList<String[]>();

for(int m = 0; m < resultList.get(0).size(); m++) {

    String[] array = new String[resultList.size()];
    for (int i = 0; i < resultList.size(); i++) {
        array[i] = resultList.get(i).get(m).toString();
    }
    data.add(array);
}
for(String[] array : data) {
    System.out.println(Arrays.toString(array));
}
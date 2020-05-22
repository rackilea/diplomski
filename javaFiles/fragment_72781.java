List<List<String>> arrayList = new ArrayList<List<String>>();
List<String> stringLine = new ArrayList<String>();
stringLine.add("5");
stringLine.add("7");
arrayList.add(stringLine);
for (List<String> list : arrayList) {// each list in the arrayList
    for (String current : list) {// each element in each list
        System.out.println(current);
    }
}
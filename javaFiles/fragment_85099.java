List<List<String>> arrList = new ArrayList<>();

for (int i = 0; i < 5; i++) {
    List<String> arr = new ArrayList<>();
    arr.add("a" + i);
    arr.add("b" + i);
    arr.add("c" + i);
    arrList.add(arr);
}
System.out.println(arrList);
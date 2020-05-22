List<List<Integer>> integerLists = Arrays.asList(
    Arrays.asList(1, 2), 
    Arrays.asList(3, 4), 
    Arrays.asList(5)
)

List<Integer> flattened = new ArrayList<>();

for (List<Integer> integerList : integerLists) {
    flattened.addAll(integerList);
}

for (Integer i : flattened) {
    System.out.println(i);
}
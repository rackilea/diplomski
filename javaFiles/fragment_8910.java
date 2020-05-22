List<Integer> integerList = new ArrayList<>();
for(int i = 0; i < 202; i++) {
    integerList.add(i);
}
List<Integer> exclusionList = new ArrayList<>();
exclusionList.addAll(integerList);
for(int element : integerList){
    exclusionList.remove(element);
    Collections.shuffle(exclusionList);
    System.out.println(element + ", " + exclusionList.subList(0, 3));
    exclusionList.add(element);
}
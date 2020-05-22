private static List<Integer> getTheMinList(List<List<Integer>> lists){
    return lists.stream()
            .min(Comparator.comparingInt(List::size))
            .orElse(new ArrayList<>());
}
// invoked as
System.out.println(getTheMinList(List.of(list1, list2)).size());
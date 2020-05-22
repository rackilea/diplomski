public static String sortLists(List<String> firstList, List<String> secondList, List<String> thirdList) {
    @SuppressWarnings("unchecked")
    List<String>[] lists = new List[] { firstList, secondList, thirdList };
    Arrays.sort(lists, new Comparator<List<?>>() {
        @Override
        public int compare(List<?> list1, List<?> list2) {
            return list1.size() - list2.size();
        }
    });
    return "long: " + lists[0] + ", longer: " + lists[1] + ", longest: " + lists[2];
}
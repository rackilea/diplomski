public ArrayList<String> commonIds(ArrayList<ArrayList<String>> lists) {
    List<String> common = new ArrayList<>(lists.get(0));
    if (lists.size() > 1) common.retainAll(lists.get(1));

    return common;
}
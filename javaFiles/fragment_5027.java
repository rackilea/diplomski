public static boolean listsHaveSameSize(List<List<?>> allLists) {
    List<?> first = null;
    for (List<?> list: allLists) {
        if (first == null) {
             first = list;
        } else if (list.size() != first.size()) {
             return false;
        }
    }
    return true;
}
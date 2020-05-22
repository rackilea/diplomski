public static void removeAllSubList(List<?> list, List<?> subList) {
    // find first occurrence of the subList in the list, O(nm)
    int i = Collections.indexOfSubList(list, subList);
    // if found
    if (i != -1) {
        // bulk remove, O(m)
        list.subList(i, i + subList.size()).clear();
        // recurse with the rest of the list
        removeAllSubList(list.subList(i, list.size()), subList);
    }
}
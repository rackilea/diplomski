private static List mergeIntoList(List source, List listToAdd, int index) {
    List innerList = new ArrayList(listToAdd);
    innerList.add(0, source.get(index));

    List mergedList = new ArrayList(source);
    mergedList.set(index, innerList);

    return mergedList;
}
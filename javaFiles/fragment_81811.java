private List<MyObject> unique(List<MyObject> list) {
    List<MyObject> uniqueList = new ArrayList<>();
    Set<MyObject> uniqueSet = new HashSet<>();
    for (MyObject obj : list) {
        if (uniqueSet.add(obj)) {
            uniqueList.add(obj);
        }
    }
    return uniqueList;
}
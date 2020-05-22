Single<List<Integer>> singleList1 = ...
Single<List<Integer>> singleList2 = ...

Single.zip(singleList1, singleList2, (list1, list2) -> {

    if (list1.isEmpty()) {
        return list2;
    }
    if (list2.isEmpty()) {
        return list1;
    }

    Set<Integer> set = new HashSet<>(list1);
    List<Integer> result = new ArrayList<>(list2.size());

    for (Integer i : list2) {
        if (set.contains(i)) {
            result.add(i);
        }
    }

    return result;
});
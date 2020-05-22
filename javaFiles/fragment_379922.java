public static void main(String[] args) {

    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 3, 6, 7));

    Set<Integer> intersection = new HashSet<Integer>(set1);
    intersection.retainAll(set2);

    // set1 is now the union of set1 and set2
    set1.addAll(set2);

    // set1 is now (union - intersection)
    // All elements in set1 or set2, but not in both set1 & set2
    set1.removeAll(intersection);

    for(Integer n : set1) {
        System.out.println(n);
    }
}
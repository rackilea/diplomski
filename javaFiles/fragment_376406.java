private static void unionAndIntersection(Set<Integer> setA, Set<Integer> setB) {
    Set<Integer> union = new HashSet<>();
    union.addAll(setA);
    union.addAll(setB);

    Set<Integer> intersection = setA.parallelStream()
            .filter(setB::contains)
            .collect(Collectors.toSet());

    System.out.println("Union : " + union);
    System.out.println("Intersection : " +intersection);
}

public static void main(String[] args){ 
    List<Set<Integer>> listA = new ArrayList<>();
    List<Set<Integer>> listB = new ArrayList<>();
    listA.stream()
        .forEach(a -> {
            listB.stream()
            .forEach(b -> unionAndIntersection(a, b));
        });
}
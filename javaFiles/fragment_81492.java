Set<Set<Node>> result = new HashSet<Set<Node>>();
for (Set<Node> s1 : NestedSet) {
    Optional<Set<Node>> findFirst = result.stream().filter(p -> !Collections.disjoint(s1, p)).findFirst();
    if (findFirst.isPresent()){
        findFirst.get().addAll(s1); 
    }
    else {
        result.add(s1);
    }
}
Set<Nodes> innerSet = degreeMap.get(degree);
if (innerSet == null) {
    innerSet = new HashSet<>();
    degreeMap.put(degree, innerSet);
}
innerSet.add(n);
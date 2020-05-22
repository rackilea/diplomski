List<Nodes> innerList = DegreeList.get(degree);
if (innerList == null) {
    innerList = new ArrayList<Nodes>();
    DegreeList.put(degree, innerList);
}
innerList.add(n);
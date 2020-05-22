for (Edges e: Edge){
    if (n.equals(e.start)||n.equals(e.end)){
        degree++;
    }
}

// insert into Map here
Set<Nodes> innerSet = degreeMap.get(degree);
if (innerSet == null) {
    innerSet = new HashSet<>();
    degreeMap.put(degree, innerSet);
}
innerSet.add(n);
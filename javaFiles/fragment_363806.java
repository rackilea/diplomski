List<A> input = ...;
HashMap<IdClass, B> bsById = new HashMap<>();
for(B b : getOutputObjectsByIds(input.stream().map(A::getId).collect(Collectors.toList()))){
    bsById.put(b.getId(), b);
}
return input.stream().map((A a)->bsById.get(a.getId())).collect(Collectors.toList());
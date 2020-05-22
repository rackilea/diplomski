final List<Triplet> tripletsOne = Triplet.listFrom(listOne);
final List<Triplet> tripletsTwo = Triplet.listFrom(listTwo);
final Map<String, List<Triplet>> mapOneByNoun1 = tripletsOne.stream()
        .collect(Collectors.groupingBy(t -> t.noun1));
final Map<Object, List<Triplet>> mapOneByNoun2 = tripletsOne.stream()
        .collect(Collectors.groupingBy(t -> t.noun2));
final List<Triplet> EMPTY = Collections.emptyList();
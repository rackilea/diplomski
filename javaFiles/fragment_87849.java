boolean finished = false;
  while (!finished) {
     List<Iterator<Shape>> iteratorsWithNext = shapes.stream().filter(
           s -> s.hasNext()).collect(Collectors.toList());
     iteratorsWithNext.forEach(it -> merged.add(it.next()));
     finished = iteratorsWithNext.isEmpty();
  }
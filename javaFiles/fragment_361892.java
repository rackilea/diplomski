Map<String, Integer> programCounts;
TreeMap<Integer, Collection<String>> map = 
    new TreeMap<>(
        Multimaps.invertFrom(
           Multimaps.forMap(programCounts),
           ArrayListMultimap.create()
        ).asMap()
    );
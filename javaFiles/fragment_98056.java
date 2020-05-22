private static Map<Thing, List<Thing>> consolidateMap(Map<Thing, Thing> releasedToDraft) {
        return releasedToDraft.entrySet().stream()
                .collect(groupingBy(
                        Map.Entry::getValue,
                        mapping(Map.Entry::getKey, toList())
                ));
    }
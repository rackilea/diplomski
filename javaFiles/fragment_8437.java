Map<Integer, JournalEntry> identity = entries.stream()
            .collect(Collectors.toMap(JournalEntry::getId, Function.identity()));

    Map<Integer, Set<Integer>> map = entries.stream()
            .collect(Collectors.groupingBy(
                    x -> x.getParentId() == null ? -1 : x.getParentId(),
                    Collectors.mapping(JournalEntry::getId, Collectors.toSet())));
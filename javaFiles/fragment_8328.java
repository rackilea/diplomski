Map<String, Set<String>> entryMaps = new LinkedHashMap<>();
groups.forEach(group -> 
    group.getEntries().forEach(entry -> 
            entryMaps.computeIfAbsent(
                    entry.getEntryId().toLowerCase(),
                    k -> new LinkedHashSet<>())
                .add(group.getId())));
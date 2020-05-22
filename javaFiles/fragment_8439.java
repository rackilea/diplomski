private static void recursive(
        Integer parentId,
        Map<Integer, Set<Integer>> map,
        Map<Integer, JournalEntry> identity,
        JournalDTO journalDTO) {

    Set<Integer> childrenIds = map.get(parentId);

    if (childrenIds != null && !childrenIds.isEmpty()) {
        childrenIds.forEach(x -> {
            JournalDTO childDTO = toDTO(identity.get(x));
            journalDTO.getChildEntries().add(childDTO);
            recursive(x, map, identity, childDTO);
        });
    }
}
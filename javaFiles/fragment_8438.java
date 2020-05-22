// get those that have no parents first
Set<Integer> ids = map.get(-1);

// this is the ultimate result 
List<JournalDTO> all = new ArrayList<>();

// for each entity with no parents, start searching in the map
ids.forEach(x -> {
     JournalDTO parentDTO = toDTO(identity.get(x));
     recursive(x, map, identity, parentDTO);
     all.add(parentDTO);
});
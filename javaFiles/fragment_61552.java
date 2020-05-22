List<List<Map<Integer, Integer>>> RPs = new ArrayList<>();

for (int i = 0; i < NUMBER_OF_ARRAYLISTS; i++) {
    List<Map<Integer, Integer>> list = new ArrayList<>();
    for (int j = 0; j < NUMBER_OF_MAPS_PER_LIST; j++) {
        list.add(new HashMap<Integer, Integer>());
    }
    RPs.add(list);
}
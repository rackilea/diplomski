static Collection<HeuristicResult> concatenate(List<HeuristicResult> list) {
    HashMap<Integer, HeuristicResult> keys = new HashMap<>();

    for (HeuristicResult x: list) {
        HeuristicResult hr = keys.get(x.keyResult);

        if (hr != null) {
            // Merge hr and x.
            Set<Integer> moves = new HashSet<>();
            moves.addAll(hr.getMoves());
            moves.addAll(x.getMoves());

            hr.moves.clear();
            hr.moves.addAll(moves);
        }
        else {
            // Create a new entry into our keys map if it doesn't exist.
            keys.put(x.keyResult, x);
        }
    }
    return keys.values();
}
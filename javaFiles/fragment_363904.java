static void generateCombinationOf(List<String> items,
        List<String> selected, int index, List<List<String>> result) {
    if (index >= items.size()) {
        result.add(new ArrayList<>(selected));
    } else {
        generateCombinationOf(items, selected, index + 1, result);
        selected.add(items.get(index));
        generateCombinationOf(items, selected, index + 1, result);
        selected.remove(selected.size() - 1);
    }
}

static List<List<String>> generateCombinationOf(List<String> items) {
    List<List<String>> result = new ArrayList<>();
    List<String> selected = new ArrayList<>();
    generateCombinationOf(items, selected, 0, result);
    return result;
}
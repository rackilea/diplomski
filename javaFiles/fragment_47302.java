public List<Integer> matchAverage(double target, List<Integer> items) {
    for (int i = 1; i <= 50; i++) { // arbitrary limit of 50
        List<Integer> match = matchAverage(target, items, new ArrayList<>(), 0, i);
        if (match != null) return match;
    }
    throw new RuntimeException("Average not found.");
}

private List<Integer> matchAverage(double target, List<Integer> items, List<Integer> selected, int sum, int left) {
    for (int i = 0; i < items.size(); i++) {
        Integer item = items.get(i);
        selected.add(item);
        sum += item;
        if (left == 1) {
            if (sum / (double) selected.size() == target) {
                return selected;
            }
        } else {
            List<Integer> match = matchAverage(target, items.subList(i, items.size()), selected, sum, left - 1);
            if (match != null) return match;
        }
        sum -= item;
        selected.remove(selected.size() - 1);
    }
    return null;
}
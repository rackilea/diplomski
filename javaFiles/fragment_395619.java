public List<Integer> findDiff(int[] first, int[] second) {
  Map<Integer, Integer> count = new HashMap<>();
  for (int value : first) {
    int current = count.getOrDefault(value, 0);
    count.put(value, current + 1);
  }
  for (int value : second) {
    int current = count.getOrDefault(value, 0);
    count.put(value, current - 1);
  }
  List<Integer> result = new ArrayList<>();
  for (Map.Entry<Integer, Integer> entry : count.getEntrySet()) {
    int diff = entry.getValue();
    int times = Math.abs(diff);
    for (int i = 0; i < times; i++) {
      result.add(entry.getKey());
    }
  }
  return result;
}
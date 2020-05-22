Map.Entry<Integer, String> prev = null;
for (Map.Entry<Integer, String> entry: collection.entrySet()) {
  if (prev != null) {
    if (entry.isBefore(prev)) {
      String current = entry.getValue();
      entry.setValue(prev.getValue();
      prev.setValue(current);
    }
  }
  prev = entry;
}
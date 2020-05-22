public Map<R, Map<C, V>> rowMap() {
  Map<R, Map<C, V>> result = rowMap;
  if (result != null) {
    return result;
  }
  rowMap = createRowMap();
  return rowMap;
}
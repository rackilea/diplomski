for (int j = arrList.size() - 1; j > i; j--) {
  if (arrList.get(j).equals(current) && occurrences >= maxOccurrences) {
    arrList.remove(j);
  } else if (arrList.get(j).equals(current)) {
    occurrences++;
  }
}
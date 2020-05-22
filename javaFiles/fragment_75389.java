for (int j = i + 1; j < arrList.size(); j++) {
  if (arrList.get(j).equals(current) && occurrences >= maxOccurrences) {
    arrList.remove(j); // This shortens the list causing us to skip the next element
    j--; // One hackish way is to go back one step

  } else if (arrList.get(j).equals(current)) {
    occurrences++;
  }
}
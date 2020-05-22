public int telExemplaren(Boek b1) {
  int count = 0;
  for (Exemplaar element: boekenlijst) {
    if (b1.getTitel().equals(element.getTitel())) {
      count++;
    }
  }
  return count;
}
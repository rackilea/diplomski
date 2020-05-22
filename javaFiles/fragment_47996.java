for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
  String str = iterator.next();
  if (count == 1) {
    iterator.remove();
  }
  count++;
}
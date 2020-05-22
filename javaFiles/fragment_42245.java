for (Iterator<String> iter = list.listIterator(); iter.hasNext(); ) {
  String a = iter.next();
  if (//remove condition) {
     iter.remove();
  }
}
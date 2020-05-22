for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
  String s = iter.next();
  if (s.equals("to_remove")) {
    iter.remove();
  }
}
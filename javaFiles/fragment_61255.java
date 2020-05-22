while (iterator.hasNext()) {
  String color = fn.apply(iterator.next());
  if (!colorSet.add(color)) {
    iterator.remove();
  }
}
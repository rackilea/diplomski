T value = iterator.next();
if (!colorSet.isEmpty() && colorSet.contains(fn.apply(value))) {
  iterator.remove();
} else {
  colorSet.add(fn.apply(value));
}
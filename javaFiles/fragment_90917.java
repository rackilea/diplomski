while(iterator.hasNext()) {
  x = iterator.next(); // get element
  // do with x what you want
  if (/*you want to remove x from the underlying list*/)
      iterator.remove();
}
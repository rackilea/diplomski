public Object frobnicate(CharSequence something) {
  Object o = getFromCache(something);
  if (o == null) {
    o = computeValue(something);
    putIntoCache(o, something);
  }
  return o;
}
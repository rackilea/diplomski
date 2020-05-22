@Override public boolean equals(Object o) {
  if (o instanceof Combination) {
    Combination<?> c = (Combination<?>) o;
    return objects.equals(c.objects);
  }
  return false;
}
public T read() {
  if (!list.isEmpty()) {
    return list.remove(0);
  }
  return null;
}
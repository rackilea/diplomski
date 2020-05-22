fun <T> combine(a: Iterator<T>, b: Iterator<T>, c: Iterator<T>): Iterator<T> {
  return iterator {
    yieldAll(a)
    yieldAll(b)
    yieldAll(c)
  }
}
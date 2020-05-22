public Enumeration<E> elements() {
  return new Enumeration<E>() {
    int count = 0;

    public boolean hasMoreElements() {
      return count < elementCount;
    }

    public E nextElement() {
      synchronized (Vector.this) {
        if (count < elementCount) {
          return (E)elementData[count++];
        }
    }
      throw new NoSuchElementException("Vector Enumeration");
    }
  };
}
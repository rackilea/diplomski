/**
   * Returns an iterator over pairs of elements returned by the iterator.
   * 
   * @param iterator the base iterator
   * @return the paired iterator
   */
  public static <T> Iterator<List<T>> paired(Iterator<T> iterator) {
    return new Iterator<List<T>>() {
      @Override
      public boolean hasNext() {
        return iterator.hasNext();
      }

      @Override
      public List<T> next() {
        T first = iterator.next();
        if (iterator.hasNext()) {
          return Arrays.asList(first, iterator.next());
        } else {
          return Arrays.asList(first);
        }
      }
    };
  }

  /**
   * Returns an stream of pairs of elements from a stream.
   * 
   * @param stream the base stream
   * @return the pair stream
   */
  public static <T> Stream<List<T>> paired(Stream<T> stream) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(paired(stream.iterator()), Spliterator.ORDERED),
        false);
  }

  @Test
  public void iteratorAndStreamsExample() {
    List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f");
    Iterator<List<String>> pairs = paired(strings.iterator());
    while (pairs.hasNext()) {
      System.out.println(pairs.next());
      // [a, b]
      // [c, d]
      // [e, f]
    }

    paired(Stream.of(1, 2, 3, 4, 5, 6, 7, 8)).forEach(System.out::println);
    // [1, 2]
    // [3, 4]
    // [5, 6]
    // [7, 8]
  }
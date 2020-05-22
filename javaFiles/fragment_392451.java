/**
   * A view on a list of its elements as pairs.
   * 
   * @param <T> the element type
   */
  static class PairList<T> extends AbstractList<List<T>> {
    private final List<T> elements;

    /**
     * Creates a new pair list.
     * 
     * @param elements the elements
     * 
     * @throws NullPointerException if elements is null
     * @throws IllegalArgumentException if the length of elements is not even
     */
    public PairList(List<T> elements) {
      Objects.requireNonNull(elements, "elements must not be null");
      this.elements = new ArrayList<>(elements);
      if (this.elements.size() % 2 != 0) {
        throw new IllegalArgumentException("number of elements must have even size");
      }
    }

    @Override
    public List<T> get(int index) {
      return Arrays.asList(elements.get(index), elements.get(index + 1));
    }

    @Override
    public int size() {
      return elements.size() / 2;
    }
  }
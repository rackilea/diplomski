return new AbstractIterator<Integer>() {
  int next = getStart();

  @Override protected Integer computeNext() {
    if (isBeyondEnd(next)) {
      return endOfData();
    }
    Integer result = next;
    next = next + getStep();
    return result;
  }
};
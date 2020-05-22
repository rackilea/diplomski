class MinHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer one, Integer two) {
    return mDistances[one] - mDistances[two];//...
    }
  }
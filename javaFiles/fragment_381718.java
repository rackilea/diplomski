class SortTask extends RecursiveAction {
    final long[] array; final int lo; final int hi;
    SortTask(long[] array, int lo, int hi) {
    this.array = array; this.lo = lo; this.hi = hi;
 }

 protected void compute() {
    if (hi - lo < THRESHOLD)
       sequentiallySort(array, lo, hi);
    else {
       int mid = (lo + hi) >>> 1;
       invokeAll(new SortTask(array, lo, mid),
                 new SortTask(array, mid, hi));
       merge(array, lo, hi);
    }
  }
}
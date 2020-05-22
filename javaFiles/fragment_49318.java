@HotSpotIntrinsicCandidate
public final native boolean compareAndSwapInt(Object o, long offset,
                                              int expected,
                                              int x);

@HotSpotIntrinsicCandidate
public final boolean weakCompareAndSwapInt(Object o, long offset,
                                                  int expected,
                                                  int x) {
    return compareAndSwapInt(o, offset, expected, x);
}
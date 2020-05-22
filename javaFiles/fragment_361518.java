/**
 * The very basic form w/ TODOs on checks, concurrency issues, init, etc.
 */
final public static class ParArray {
    private ParallelLongArray parr;
    private final long[] arr;
    public ParArray (long[] arr){
        this.arr = arr;
    }
    public final ParArray par() {
        if(parr == null)
            parr = ParallelLongArray.createFromCopy(arr, new ForkJoinPool()) ;
        return this;
    }
    public final ParallelLongArray map(LongOp op) {
        return parr.replaceWithMapping(op);
    }
    public final long[] values() { return parr.getArray(); }
}
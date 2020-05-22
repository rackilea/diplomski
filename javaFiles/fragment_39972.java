private static <T> Stream<T> asSlowPagedSource(long pageSize, List<T> things) {
    return PagingSpliterator.paged( (offset, limit, totalSizeSink) -> {
        totalSizeSink.accept(things.size());
        if(offset>things.size()) return Collections.emptyList();
        int beginIndex = (int)offset;
        assert beginIndex==offset;
        int endIndex = Math.min(beginIndex+(int)limit, things.size());
        System.out.printf("Page %6d-%6d:\t%s%n",
                          beginIndex, endIndex, Thread.currentThread());
        // artificial slowdown
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
        return things.subList(beginIndex, endIndex);
    }, pageSize, true);
}
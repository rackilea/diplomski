for (
    ListIterator<PerfStatBean> iter = statFilterResults.listIterator();
    iter.hasNext()
) {
    ++i;
    PerfStatBean perfBean = iter.next();
    iter.set(null);
    ...
}
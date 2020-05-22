static final <T extends Comparable<? super T>> T max(T t1, T t2) {
    return t1.compareTo(t2)>=0? t1: t2;
}
static final <T extends Comparable<? super T>> T min(T t1, T t2) {
    return t1.compareTo(t2)<0? t1: t2;
}
void someMethod2(Timeslot t1, Timeslot t2) {
    Timeslot start=min(t1, t2), end=max(t1, t2);
    // do something with start and end
}
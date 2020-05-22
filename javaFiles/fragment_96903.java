void someMethod(Timeslot t1, Timeslot t2) {
    Timeslot start=t1, end=t2;
    if (t1.compareTo(t2) < 0) {
        start = t2;
        end = t1;
    }
    // do something with start and end
}
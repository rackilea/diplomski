int priority(Day d) {
    switch(d) {
    case SUNDAY:
    case MONDAY:
        return 10; // max priority
    case TUESDAY:
        return 5;
    default:
        return 0;
    }
}
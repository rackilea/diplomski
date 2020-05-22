public int compare(Event e1, Event e2) {
    // nulls are equal
    if (e1 == null && e2 == null) {
        return 0;
    } 
    // A null is always less than anything.
    if (e1 == null) {
        return -1;
    }
    if (e2 == null) {
        return 1;
    }
    // null dates are equal
    if (e1.getDate() == null && e2.getDate() == null) {
        return 0;
    }
    // A null is always less than anything.
    if (e1.getDate() == null) {
        return -1;
    }
    if (e2.getDate() == null) {
        return 1;
    }
    // All present - use normal date comparison.
    return e1.getDate().compareTo(e2.getDate());
}
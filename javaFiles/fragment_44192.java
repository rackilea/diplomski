MutableIntList list = ...;
IntListUtils.sort(list, (a, b) -> {
    // negative before non-negative
    // otherwise, smallest numbers first
    if (a == b) { return 0; }
    if (a < 0 && b < 0) {
        return (a < b) ? 1 : -1;
    }
    return (a < b) ? -1 : 1;
});
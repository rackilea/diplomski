Collections.sort(categories, (a, b) -> {
    if (a.id != b.id) {
        if (a.id == -1) {
            return -1;
        }
        if (b.id == -1) {
            return 1;
        }
        if (a.id == 0) {
            return -1;
        }
        if (b.id == 0) {
            return 1;
        }
    }
    return a.name.compareTo(b.name);
});
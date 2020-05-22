if (i - start > 1) {
        _sort(start, i);
    }
    if (end - i > 1) {
        _sort(i, end);
    }
if (Character.isDigit(c)) {
    // ...
} else {
    if (count == 0) {
        // Single-run-length characters have an implicit "1" prepended
        count = 1;
    }
    while (count > 0) {
        // ..
    }
}
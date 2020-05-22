public void method(...) {
    Object o = ...
    Object p = ...
    while (...) {
        // Do things to 'o' and 'p'
    }
    // No further references to 'o'
    // Do lots more things to 'p'
}
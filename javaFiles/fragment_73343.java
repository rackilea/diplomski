// We don't necessarily worry about testing this version, it is "too simple to break"
void doSomethingCool(...) {
    doSomethingCool(ID.new, ...);
}

// Unit tests measure this function instead, which is easier to test and has
// all of the complicated logic
void doSomethingCool(ID id, ...) {
    // ...
}
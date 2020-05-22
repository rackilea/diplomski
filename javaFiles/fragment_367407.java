private final SomeUnsafeObject someObject = ...;
 ...
 synchronized (someObject) {
    // only one thread allowed inside this block at a time
    someObject.someUnsafeMethodCall(...);
 }
 // no accesses (read or write) outside of the synchronized block
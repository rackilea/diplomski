void someMethod() {
    if (someThing) {
         int x = 1;
    }
    // no x defined here
    if (somethingElse) {
         // no x here, so we may define a new one
         string x = "Hello";
    }
}
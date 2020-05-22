// A method that assigns a new reference; the calling code sees no change
void changeReference(String[] theArray) {
    theArray = new String[1];        // Now we're not using the caller's object anymore
    theArray[0] = "I was changed";
}

// A method that uses the above
void someMethod() {
    String[] foo = new String[3];
    foo[0] = "Original 0";
    foo[1] = "Original 1";
    foo[2] = "Original 2";

    this.changeReference(foo);
    System.out.println(foo[0]); // Prints "Original 0", our reference wasn't changed
}
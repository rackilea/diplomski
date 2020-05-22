try {
    int x = bla();
    foo = x; // In case of an exception this line is never reached...or is it?
    callAnotherFunctionThatThrowsAnException();  // Now what?
} catch (Exception ex) {
    foo = 0; // But the compiler complains
             // that foo might have been initialized,
             // and now it is correct.
}
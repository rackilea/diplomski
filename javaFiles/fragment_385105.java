if (parameter == EXCEPTION_EXPECTED) {
    try {
        method(parameter);
        fail("didn't throw an exception!");
    } catch (ExpectedException ee) {
        // Test succeded!
    }
}
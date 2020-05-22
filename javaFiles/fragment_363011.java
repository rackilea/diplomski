public void attemptUpTo10Times() {
    for(int i = 0; i < 10; ++i) {
        try {
            methodToCall();
            break; // exit the loop if no exception were thrown
        } catch (final FooException ignore) {
            if (i == 9) {
                throw new IllegalStateException("Failed 10 times in a row");
            }
        }
    }
}
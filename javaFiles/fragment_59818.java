public Foo bar() {
    try {
        return unsafeBar();
    } catch(BuzzException e) {
        //Error handling
    }
}

public Foo unsafeBar() throws BuzzException {
    //business logic that may throw
    //...
    //end even more
}
public Object myFunction(String something, String somethingElse) {
    // First option - Not so good.
    if(something == null || somethingElse == null) {
        throw new IllegalArgumentException("Invalid parameters. Can not be null");
    }

    // Second option - much better.

    if(something == null) {
        throw new IllegalArgumentException("Something can not be null");
    }

    if(somethingElse == null) {
        throw new IllegalArgumentException("Something else can not be null");
    }
}
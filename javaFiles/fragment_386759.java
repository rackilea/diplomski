void example() {
    try {
        //do some stuff that may throw an exception
        //do stuff that should only be done if no exception is thrown
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
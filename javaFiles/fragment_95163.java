public void t() {
    tryCatchAndLog(() -> {
        throw new NullPointerException();
    });

    tryCatchAndLog(this::throwX);

}

public void throwX() throws Exception {
    throw new Exception();
}
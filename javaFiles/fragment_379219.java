public final void updateEntity() {
    if (checkTheTick()) {
        doUpdateEntity();
    }
}

protected void doUpdateEntity() {
    ... // the original implementation of updateEntity goes here
}
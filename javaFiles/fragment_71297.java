void BtnImportActionPerformed() {
    for(int i = 0l i < 10; i++) {
        try {
            writefiletoDB();
        } catch (SomeException e) {
            // do anything else?
            return;
        }
    }
}

void writefiletoDB() throws SomeException {
    try {
        doSomething();
    } catch (SomeException e) {
        // log it?  something else?
        throw e;
    }
}
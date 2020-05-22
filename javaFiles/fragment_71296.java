void BtnImportActionPerformed() {
    for(int i = 0l i < 10; i++) {
        writefiletoDB();
    }
}

void writefiletoDB() {
    try {
        doSomething();
    } catch (SomeException e) {
        return;
    }
}
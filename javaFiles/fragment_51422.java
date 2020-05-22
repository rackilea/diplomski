try {
    throwCheckedException();
    if (!someBoolean) {
        Data data = createData();
        handle(data);
    }
} catch (IOException e) {
    Data data = createDataFromMessage(e.getMessage());
    handle(data);
}
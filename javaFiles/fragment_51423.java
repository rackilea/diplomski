try {
    throwCheckedException();
} catch (IOException e) {
    Data data = createDataFromMessage(e.getMessage());
    handle(data);
}

if (!someBoolean) {
    Data data = createData();
    handle(data);
}
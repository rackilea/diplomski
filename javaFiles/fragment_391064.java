TransactionRecord readRecord(ObjectInputStream stream) throws OptionalDataException, IOException {
    try {
        transactionRecord = (TransactionRecord) stream.readObject();
    } catch (OptionalDataException e) {
        if (e.eof) {
            return null;
        } else {
            throw e;
        }
    }
    return transactionRecord;
}
.....
TransactionRecord record;
while ((record = readRecord(inTrans)) != null) {
    doSomethingWithRecord(record);
}
endOfFile();
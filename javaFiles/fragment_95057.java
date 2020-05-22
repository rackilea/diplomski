template.execute(new CollectionCallback<Void> {

    Void doInCollection(DBCollection collection) {

        BulkWriteOperation operation = collection.initialize(Uno|O)rderedBulkOperation();
        // bulk code goes here
        operation.execute();
        return null;
    }
}
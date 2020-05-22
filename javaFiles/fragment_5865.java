collection.insertOne(doc, new SingleResultCallback<Void>() {
    @Override
    public void onResult(final Void result, final Throwable t) {
        //Do something here.
        System.out.println("Inserted!");
    }
});
// Do something to show that the Document was not inserted yet.
System.out.println("Inserting...")
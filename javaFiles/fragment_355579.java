@Override
    protected String doInBackground(String... params) {
        // send object to server
        Response<Book> responseCreateObject = syn.createObject(b).send();
        if (responseCreateObject.getHttpResultCode() == Response.HTTP_CODE_CREATED) {
            Log.d(TAG, "Success. Item created.");
        } else {
            Log.d(TAG, "Fail.");
        }

        // get objects from server
        Response<List<Book>> responseGetObjects = syn.getObjects(Book.class).send();
        if (responseGetObjects.getHttpResultCode() == Response.HTTP_CODE_SUCCESS) {
            List<Book> books = responseGetObjects.getData();
            Log.d(TAG, "Success. Items downloaded: " + books.size());
        } else {
            Log.d(TAG, "Fail.");
        }

        return "Executed";
    }
SyncHttpClient client = new SyncHttpClient();

    // Should be success
    client.get("http://10.17.1.72:8080/contacts", new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(String response) {
            Log.d(TAG, "GET - ID: 1 - Success expected -> Got success");
            auxArray.add("1");
        }

        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
            super.onFailure(arg0, arg1, arg2, arg3);
            Log.d(TAG, "GET - ID: 1 - Success expected -> Got failure");
        }
    });
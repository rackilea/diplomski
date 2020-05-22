mAsyncTask = new MyCustomAsyncTask(/* constructor params */) {
    @Override
    protected void onPostExecute(Void result) {
        // can access activity members here
        mAsyncTask = null;
    }
}.execute();
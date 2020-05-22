private class HttpAsyncTask extends AsyncTask<List<String>, Integer, List<String>> {

    private Handler handler = null;
    public HttpAsyncTask (Handler handler) {
        this.handler = handler;
    }

    protected Void doInBackground(Void... params) {
       //Perform your task
       // When you know that task is finished , fire following code
                if (null != handler) {
                  Message message = handler.obtainMessage();
                        message.obj = Any data you want to sent to the activity
                        message.what = 1 ; ( Optional )
                        handler.sendMessage(message);
                }

    }
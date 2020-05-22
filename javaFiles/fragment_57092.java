class B implements AsyncTaskCompleteListener<JSONObject> {

    public void onTaskComplete(JSONObject result) {
        // do whatever you need
    }

    public void launchTask(String url) {
        ApiCaller a = new ApiCaller(context, ArrayList<NameValuePair> params, this);
        ApiCaller.execute(url);
    }
}


class ApiCaller extends AsyncTask<String, Void, String> {
    private AsyncTaskCompleteListener<String> callback;

    public ApiCaller(Context context, ArrayList<NameValuePair> params, AsyncTaskCompleteListener<String> cb) {
        this.context = context;
        this.callback = cb;
    }

    protected void onPostExecute(String result) {
       finalResult = result;
       progressDialog.dismiss();
       System.out.println("on Post execute called");
       callback.onTaskComplete(result);
   }  
}
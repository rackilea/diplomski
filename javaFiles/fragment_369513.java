private class AsyncCallWS extends AsyncTask<String, Void, String> {

    private ProgressDialog dialog;
    private Activity activity;
    public String methodName="";
    private WebService ws;

    public AsyncCallWS(Activity activity,String methodName) {
        this.activity = activity;
        this.dialog = new ProgressDialog(activity);
        this.methodName = methodName;
    }

    @Override
    protected Void doInBackground(String... params) {
        ws = new WebService(PublicVariable.NAMESPACE, PublicVariable.URL);
        PropertyInfo pi= new PropertyInfo();
        pi.setName("UserID");
        pi.setValue("1");
        pi.setType(String.class);

        String wsOutput = ws.CallMethod("GetPersonalInfo", pi);

        return wsOutput;
    }

    @Override
    protected void onPostExecute(String result) {

        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }

        Log.d("Ehsan","OUTPUT IS:"+ result);
    }
}
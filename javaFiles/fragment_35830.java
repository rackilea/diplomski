@Override
 public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException 
 {
        context=this.cordova.getActivity().getApplicationContext();
        String myurl = args.getString(0);
        if (action.equals("plugin1"))
        {
            // Pass callbackContext to your actual code which performing the work.
            new DownloadManager(callbackContext).execute(myurl);
            return true;
        }

        callbackContext.error("error");
        return false;
 }

 public class DownloadManager extends AsyncTask<String, String, String> {
    private CallbackContext callbackContext;
    public DownloadManager(CallbackContext callbackContext) {
         this.callbackContext = callbackContext;
    }

    @Override
    public String doInBackground(String... arg0) {
        downloadapk(arg0[0]);
        installapk();
        this.callbackContext.success();
        return null;
        //Here I want to return to javascript.How can I callback to the javascript function from //async method?? 
    }
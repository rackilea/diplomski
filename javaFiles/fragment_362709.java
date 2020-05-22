public class DataBaseTask extends AsyncTask<String, Void, String> {

    private static final String TAG = "DataBaseTask";

    // Just in case you want a ProgressDialog uncomment this and the associated code
    //private ProgressDialog pDialog;

    private DataBaseTaskListener mListener;

    Context mContext;
    String mCommand = "";
    Token mToken;


    public DataBaseTask(Context context, String command, Token token, DataBaseTaskListener listener){
        this.mContext = context;
        this.mCommand = command;
        this.mToken = token;
        this.mListener = listener;
    }


    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try{
            // Put your code here!!
        }
        catch(Exception ex){
            Log.e(TAG, ex.getMessage());
        }
        return result;
    }


    @Override
    protected void onPostExecute(String result) {
        try{
            // In case you want a ProgressDialog
            //pDialog.dismiss();

            // Trigger the listener for the call back sending the result
            mListener.onCompletedSendData(result);

             Log.e(TAG, "onPostExecute result: " + mData);
        }
        catch(Exception ex){
            Log.e(TAG, ex.getMessage());
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // In case you want a ProgressDialog
        //pDialog = new ProgressDialog(context);
        //pDialog.setMessage("Sending Data...");
        //pDialog.setIndeterminate(false);
        //pDialog.setCancelable(false);
        //pDialog.show();
    }
}
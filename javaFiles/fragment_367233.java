public class Utilssss extends AsyncTask<String, String, String> {

    /** Implement this somewhere to get the result */
    public interface UtilssssCallback {
        void onResult(String string);
    }

    private Context mContext;
    private ProgressDialog pdia;

    private UtilssssCallback mListener;

    // constructor
    public Utilssss(Context activityContext, UtilssssCallback listener) {
        mContext = activityContext;
        mListener = listener; // save callback
    }

    @Override
    protected void onPostExecute(String result) {
        pdia.dismiss();
        mListener.onResult(result);
    }

    // rest omitted since unchanged

}
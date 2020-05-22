public class ServerConnection extends AsyncTask<String, Void, String> {

    OnResponseReceivedListener mListener;

    public void setResponseListener(OnResponseReceivedListener listener){
       mListener = listener;
    }

    // Your rest of the code
    @Override
    protected void onPostExecute(String unused) {
        mListener.onResponseReceived(unused);
        dialog.dismiss();
    }      

}
@Override
protected void onPostExecute(String[] params) {

try {
    if (mListener != null) {
       mListener.receiveData(params);
    }

    // stop Dialog
    if (pDialog.isShowing()) {
        pDialog.dismiss();
    }

} catch (Exception e) {
    e.printStackTrace();
}
}
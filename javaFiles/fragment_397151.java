@Override
    protected void onPostExecute(String param) {
    // dismiss the dialog after getting all products
    // updating UI from Background Thread
    pDialog.dismiss();
}
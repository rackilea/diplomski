class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


@Override
protected void onPreExecute() {
  super.onPreExecute();

}

@Override
protected Boolean doInBackground(String... urls) {
try {

   //here you make your api call and json parsing

} catch (IOException e) {
    e.printStackTrace();
} catch (JSONException e) {

    e.printStackTrace();
}
return false;
}

protected void onPostExecute(Boolean result) {

}
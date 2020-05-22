class GetMemoDetails extends AsyncTask<String, String, List<String>> {
    @Override
    protected List<String> doInBackground(String... arg0) {
        // TODO Auto-generated method stub
         int success;
         List<String> list=new ArrayList<String>();
         try {

             List<NameValuePair> params = new ArrayList<NameValuePair>();
             params.add(new BasicNameValuePair("pid", pid));
             JSONObject json = jsonParser.makeHttpRequest(
                     url_memo_details, "GET", params);
             Log.d("Single Memo Details", json.toString());
             success = json.getInt(TAG_SUCCESS);
             if (success == 1) {
                 JSONArray memoObj = json
                         .getJSONArray(TAG_MEMO); // JSON Array
                 JSONObject memo = memoObj.getJSONObject(0);
                 ;
                 editMemoName = (EditText) findViewById(R.id.editTextEditMemoName);
                 editMemoDetails = (EditText) findViewById(R.id.editTextEditMemoDetails);                     
                 list.add(memo.getString(TAG_MEMO_NAME));
                 list.add(memo.getString(TAG_MEMO_DETAILS));
             }else{
                 // memo with pid not found
             }
         } catch (JSONException e) {
             e.printStackTrace();
         }
        return list;
    }
    @Override
    protected void onPostExecute(List<String> result) {
          editMemoName.setText(result.get(0));
          editMemoDetails.setText(result.get(1));
    }
     @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EditMemoActivity.this);
            pDialog.setMessage("Loading memo details. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
}
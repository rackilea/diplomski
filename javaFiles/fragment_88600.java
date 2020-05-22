class AddWorkDetails extends AsyncTask<String, Void, String> {
    ProgressDialog loading;


    JSONArray jsonArray;
    AddWorkDetails(JSONArray jsonArray){
        this.jsonArray = jsonArray
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show(WorkDetailsTable.this, "Please Wait",null, true, true);
    }

    @Override
    protected String doInBackground(String... params) {
        HashMap<String, String> data = new HashMap<String,String>();
        data.put("listItems",jsonArray.toString());
        RequestHandler rh=new RequestHandler();
        String result = rh.sendPostRequest(Config.ADD_WORKDETAILS,data);
        return  result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loading.dismiss();
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
}
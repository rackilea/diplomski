private class myasyncclass extends AsyncTask<String, Void, JSONObject>{
    @Override
    protected JSONObject doInBackground(String... params) {
        //Enter code for fetching value from remote server
        return yourjsonobj;
    }
    @Override
    protected void onPostExecute(JSONObject result) {   
        //Enter code for parsing and create list view
    }
}
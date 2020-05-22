@Override
    protected void onPostExecute(Integer result) {
    if (result == 1){
        setListAdapter(adapter);
        progressDialog.dismiss();
        super.onPostExecute(result);
    }
    else
      Toast.makeText(Updates.this, "No connection..", Toast.LENGTH_LONG).show();          
    }
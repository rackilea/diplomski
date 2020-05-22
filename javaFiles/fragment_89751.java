private void getData(){

    Log.d(TAG, "getData called");
    //Showing progress dialog
    progressDialog = new ProgressDialog(MainActivity.this);
    progressDialog.setMessage("Loading posts");
    progressDialog.show();
@Override
public void onClick(View v) {

    switch (v.getId()) {
    case R.id.btnSubmitNow:
        // Submit now

        // Sample upload image
        UploadImage.uploadImage("testimage");

        new AsyncTask<Void, Void, Void>() {

            // called before execution // main/UI thread
            protected void onPreExecute() {


             progressDialog = new ProgressDialog(SignOut_Activity.this);
             progressDialog.setMessage("Uploading data, please wait...");  

            progressDialog.show();
            };

            @Override
            protected Void doInBackground(Void... params) {
                // Submit the store data
                StoreData.postData(StoreList_Activity.storesList
                        .get(StoresListAdapter.Position));
                return null;
            }

            // on store data uploaded // main/UI thread
            protected void onPostExecute(Void result) {
                progressDialog.dismiss();
                setSignOut();
                StoreList_Activity.storesList
                        .get(StoresListAdapter.Position).isSubmitted = true;
                SignOut_Activity.this.finish();
            };

        }.execute();
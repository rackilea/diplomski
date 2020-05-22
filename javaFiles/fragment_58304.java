if(progressDialog !=null)
{
    progressDialog = null;
}
progressDialog = new ProgressDialog(this.getApplicationContext());
        progressDialog.setMessage("Uploading data, please wait...");
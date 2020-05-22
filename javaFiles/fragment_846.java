protected void onPreExecute() {
    dialog=ProgressDialog.show(mContext, "", "Fetching book oversight");
    msg = Toast.makeText(context, "  File Exist  ", Toast.LENGTH_LONG).show;
    super.onPreExecute();
}



protected void onPostExecute(Void result) {
    if(dialog!=null)
    {
        dialog.dismiss();
    }
}
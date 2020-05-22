@Override
protected void onPostExecute(Object o) {
    super.onPostExecute(o);
    Log.d("actions", "onPostExecute");
    if (this.dialog.isShowing())
        this.dialog.dismiss();
}
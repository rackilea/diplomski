private class Process extends AsyncTask<TextView, Void, String> {

private WeakReference<TextView> weakTextView;

@Override
protected String doInBackground(TextView... params) {
    if(params == null||params.length=0){
         return null;
    }
    TextView tv = (TextView)params[0];
    weakTextView = new WeakReference<TextView>(tv);

    //do stuff
}

@Override
protected void onPostExecute(String message) {
    TextView tv = weakTextView.get();
   if(tv!=null){
       tv.setText(message);
 }
}
private class Process extends AsyncTask<Void, Void, String> {
private WeakReference<TextView> weakTextView;
public Process(TextView textView){
       weakTextView = new WeakReference<TextView>(textView);
}
@Override
protected String doInBackground(Void... params) {
    //do stuff
}

@Override
protected void onPostExecute(String message) {
    TextView tv = weakTextView.get();
   if(tv!=null){
       tv.setText(message);
 }
}
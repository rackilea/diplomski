//first you have to change the param (the last one) to String so your doInBackground would return String
class RestOperation  extends AsyncTask<String, Void, String>  {
private WeakReference<MainActivity> weakRef;

public RestOperation(MainActivity activity) {
    weakRef = new WeakReference<MainActivity>(activity);
}

@Override
protected String doInBackground(String... params) { 
//Java.net Http transaction happens here 
//You need to return some value here to set to the text view later
return "Something";
}

@Override
protected void onPostExecute(String result) {
    MainActivity activity = weakRef.get();
    if (activity != null) {
        //activity is still alive, updates the text view
        activity.updateText(result);
    }
}
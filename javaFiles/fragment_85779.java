private _mainActivity;

// constructor
public AsyncTask(MainActivity ma) {
    // passing reference
    _mainActivity = ma;
}

@Override
protected void onPostExecute(Integer result) {
    _mainActivity.updateTextview(result);
}
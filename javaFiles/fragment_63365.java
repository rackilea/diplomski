class MyActivity extends Activity {

  private AsyncTask<Uri,MyDataObject, MyResult> = new AsyncTask<Uri,MyDataObject, MyResult>() {
    private MyResult mResult;

    protected MyResult doInBackground(Uri... uris) {           
      int count = urls.length;
      mResult = new MyResult()

      for (int i = 0; i < count; i++) {
        MyDataObject anObject = mDataLoader.getObject(uris[i]);
        publishProgress(anObject);

        mResult.add(anObject);
        // Escape early if cancel() is called
        if (isCancelled()) break;
      }
      return totalSize;
    }

    protected void onProgressUpdate(MyDataObject... data) {
      addDataToUI(data[0]);
    }

    protected void onPostExecute(MyResult result) {
      Toast.makeText("All Done!", Toast.LENGTH_LONG).show();
    }
  }
}
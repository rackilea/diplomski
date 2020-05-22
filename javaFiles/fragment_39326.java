void doSomething() {
  new AsyncTask<String, Progress, Result>() {
    protected Result doInBackground(String... args) {
      //some code
      publishProgress(values);
      //some more code
      return result;
    }

    protected void onProgressUpdate(Progress ... values) {
      updateProgessBars(values);
    }

    protected void onPostExecute(Result result) {
      doSomethingElse(result);
    }
  }.execute();
}
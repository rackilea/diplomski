final class MyNetworkOperation extends AsyncTask<URL, Integer, Void> {
  @Override
  protected void onPreExecute(final Void param) {
    ...
  }

  @Override
  protected Void doInBackground(final URL... args) {
    ...
    return null;
  }

  @Override
  protected void onPostExecute(final Void param) {
    ...
  }
}
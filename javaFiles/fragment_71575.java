public void connect() {
  ...
  if (networkInfo != null && networkInfo.isConnected()) {
    new DownloadWebpageTask().execute(URLSTRING);
    connection = true;
  }
}
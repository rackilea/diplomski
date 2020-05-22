private void getBiographyData() {
String url = "https://www.theaudiodb.com/api/v1/json/1/search.php?s=coldplay";
AsyncHttpClient client = new AsyncHttpClient();
client.get(url, new TextHttpResponseHandler() {
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        test.setText(responseString);
     }
  });
}
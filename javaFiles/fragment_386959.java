public void load() {
    String apiURI = "https://api.mongolab.com/api/1/databases/MYDATABASE/collections/USERSUBMITTEDDATA"
        + "?apiKey=" + apiKey;

    Log.d("****Status Line***", "" + apiURI);

    try {

      // make web service connection
      final StringBuilder builder = new StringBuilder();

      final HttpGet request = new HttpGet(apiURI);
      request.setHeader("Accept", "application/json");
      request.setHeader("Content-type", "application/json");
      final DefaultHttpClient httpClient = new DefaultHttpClient();

      new AsyncTask<Void, Void, String>() {

        @Override
        protected void onPostExecute(String result) {
          super.onPostExecute(result);
          doSomethingWithReceivedData(result); //THIS METHOD IS DEFINED IN BODY OF YOUR ACTIVITY
        }

        @Override
        public String doInBackground(Void... arg) {
          try {
            HttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {

              HttpEntity entity = response.getEntity();
              InputStream content = entity.getContent();

              BufferedReader reader = new BufferedReader(
                  new InputStreamReader(content));
              String line;
              while ((line = reader.readLine()) != null) {
                builder.append(line);
              }
              Log.d("****Status Line***", "Success");

              return builder.toString();

            } else {
              Log.d("****Status Line***",
                  "Failed to download file");
            }

          } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
          }
          return null;
        }
      }.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
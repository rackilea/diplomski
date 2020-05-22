public void send(View view) {
    String apiURI = "https://api.mongolab.com/api/1/databases/MYDATABASE/collections/USERSUBMITTEDDATA?apiKey="
        + apiKey;
    try {

      // make web service connection
      final HttpPost request = new HttpPost(apiURI);
      request.setHeader("Accept", "application/json");
      request.setHeader("Content-type", "application/json");

      // Build JSON string with GSON library
      Gson gson = new Gson();

      JsonElement jsonElement = gson.toJsonTree(tempData);
      String json = gson.toJson(jsonElement);
      StringEntity entity = new StringEntity(json);

      Log.d("****Parameter Input****", "Testing:" + json);
      request.setEntity(entity);
      // Send request to WCF service
      final DefaultHttpClient httpClient = new DefaultHttpClient();

      new AsyncTask<Void, Void, Void>() {
        @Override
        public Void doInBackground(Void... arg) {
          try {
            HttpResponse response = httpClient.execute(request);
            Log.d("WebInvoke", "Saving: "
                + response.getStatusLine().toString());
            // Get the status of web service
            BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity()
                    .getContent()));
            // print status in log
            String line = "";
            while ((line = rd.readLine()) != null) {
              Log.d("****Status Line***", "Webservice: " + line);

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
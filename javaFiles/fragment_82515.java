protected Void doInBackground(Void... arg0) {
    HttpHandler sh = new HttpHandler();

    // Making a request to url and getting response
    String jsonStr = sh.makeServiceCall(url);

    Gson gson = new Gson();
    YourPOJOClass parsedResponse = gson.fromJson(jsonStr, YourPOJOClass.class);
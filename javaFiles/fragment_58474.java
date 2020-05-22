client.get(PRICE_TRY_URL, new TextHttpResponseHandler() {

    @Override
    public void onSuccess(int statusCode, Header[] headers, String res) {
            // called when response HTTP status is "200 OK"
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(responseBodyString);
            JsonObject bpi = jsonObject.get("bpi").getAsJsonObject();
            JsonObject tryObject = bpi.get("TRY").getAsJsonObject();
            String rate = tryObject.get("rate").getAsString();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
    }   
  }
);